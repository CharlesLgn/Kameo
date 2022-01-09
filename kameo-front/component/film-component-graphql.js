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
        let name = this.getAttribute("name")
        const image = this.getAttribute("image")
        let summary = this.getAttribute("summary")
        summary = summary.length > 150 ? summary.substring(0, 150) + "…" : summary
        name = name.length > 20 ? name.substring(0, 20) + "…" : name
        this.shadow.querySelector("#film-image").innerHTML = `<img id="film-image" alt="picture" height="245" src="` + image + `"/>`
        this.shadow.querySelector("#film-name").innerHTML = name
        this.shadow.querySelector("#film-summary").innerHTML = summary
    }
}

customElements.define('film-component', FilmComponent);