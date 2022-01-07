class ProgressCircleComponent extends HTMLElement {

  constructor() {
    super()
    const note = this.getAttribute("note"), percent = note * 10
    this.shadow = this.attachShadow({mode: 'open'})
    this.shadow.innerHTML = `<style>
*
{
  margin:0;
  padding:0;
  font-family:'Roboto',sans-serif;
}
/* .box:hover
{
 transform:scale(1.2);
} */
.box .percent
{
  width:50px;
  height:50px;
  position:relative;
}
.box .percent svg
{
  width:50px;
  height:50px;
  position:relative;
}
.box .percent svg circle
{
  width:50px;
  height:50px;
  fill:none;
  stroke-width:10;
  stroke:#000;
  transform:translate(5px,5px);
  stroke-dasharray:126;
  stroke-dashoffset:126;
  stroke-linecap:round;
}
.box .percent svg circle:nth-child(1)
{
  stroke-dashoffset:0;
  stroke:#f3f3f3;
}
.box .percent svg circle:nth-child(2)
{
  stroke-dashoffset:calc(126 - (126 * `+percent+`) / 100);
  stroke:#03a9f4;
}
.box .percent .num
{
  top:0;
  left:0;
  width:100%;
  height:100%;
  display:flex;
  justify-content:center;
  align-items:center;
  position:absolute;
  color:#111;
}
.box .percent .num h2
{
  font-size:48px;
}
.box .percent .num h2 span
{
  font-size:24px;
}
.box .text
{
  padding 10px 0 0;
  color:#999;
  font-weight:700;
  letter-spacing:1px;
}


</style>
<div class="box">
  <div class="percent">
    <svg>
      <circle cx="20" cy="20" r="20"></circle>
      <circle cx="20" cy="20" r="20"></circle>
    </svg>
    <div class="num">
      <h4>` + note + `</h4>
    </div>
  </div>
</div>`
  }

  connectedCallback() {
    const note = this.getAttribute("note"),
      percent = note * 10
    this.shadow.querySelector("#note").innerHTML = note
  }
}

customElements.define('progress-circle', ProgressCircleComponent);