class HeaderComponent extends HTMLElement {

  constructor() {
    super()
    this.shadow = this.attachShadow({mode: 'open'})
    this.shadow.innerHTML = `
                <link rel="stylesheet" href="../css/style.css"/>
                <header>
                  <h1 id="header" style="cursor:pointer">Kameo</h1>
                </header>
                `
  }

  connectedCallback() {
    this.shadow.querySelector("#header").addEventListener('click', () => window.location = "index.html")
  }
}

customElements.define('header-component', HeaderComponent);