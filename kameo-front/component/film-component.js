class FilmComponent extends HTMLElement {

  constructor() {
    super()
    this.shadow = this.attachShadow({mode: 'open'})
    this.shadow.innerHTML = `
                <link rel="stylesheet" href="../css/style.css"/>
                <a href="." id="film-link">
                  <h2 id="film-name">Exercice 1</h2>
                  <div class="content">
                    <img id="film-image" alt="picture" height="245"/>
                  </div>
                  <div class="foot">
                    <p id="film-summary"></p>
                  </div>
                </a>`
  }

  connectedCallback() {
    const id = this.getAttribute("id")
    this.shadow.querySelector("#film-link").setAttribute("href", "./film.html?id="+id)
    fetch('http://localhost:8080/film/' + id)
      .then(data => data.json())
      .then(data => {
        let sumary = data["summary"].length > 150
          ? data["summary"].substring(0, 150) + "…"
          : data["summary"]
        let name = data["name"].length > 20
          ? data["name"].substring(0, 20) + "…"
          : data["name"]
        this.shadow.querySelector("#film-image").setAttribute("src", data["imageUrl"])
        this.shadow.querySelector("#film-name").innerHTML = name
        this.shadow.querySelector("#film-summary").innerHTML = sumary
      })
  }
}

customElements.define('film-component', FilmComponent);