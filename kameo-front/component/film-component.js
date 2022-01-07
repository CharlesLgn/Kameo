class FilmComponent extends HTMLElement {

  constructor() {
    super()
    this.shadow = this.attachShadow({mode: 'open'})
    this.shadow.innerHTML = `
                <link rel="stylesheet" href="css/style.css"/>
                <script src="component/progress-circle.js"></script>
                <a href="." id="film-link">
                  <h2 id="film-name"></h2>
                  <div id="film-image" class="content"></div>
                  <div class="foot">
                    <p id="film-summary"></p>
                  </div>
                </a>`
  }

  connectedCallback() {
    const id = this.getAttribute("id")
    this.shadow.querySelector("#film-link").setAttribute("href", "./film.html?id=" + id)
    fetch('http://localhost:8080/film/' + id)
      .then(data => data.json())
      .then(data => {
        let sumary = data["summary"].length > 150
          ? data["summary"].substring(0, 150) + "…"
          : data["summary"]
        let name = data["name"].length > 20
          ? data["name"].substring(0, 20) + "…"
          : data["name"]
        this.shadow.querySelector("#film-image").innerHTML = `<img id="film-image" alt="picture" height="245" src="` + data["imdb"].image + `"/>`
        this.shadow.querySelector("#film-name").innerHTML = name
        this.shadow.querySelector("#film-summary").innerHTML = sumary
      })
  }
}

customElements.define('film-component', FilmComponent);