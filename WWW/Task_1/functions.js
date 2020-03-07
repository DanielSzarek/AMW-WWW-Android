function changeColor() {
  document.getElementById('ColorChange').style.color = 'red';
  document.getElementById("ColorChange").style.fontSize = "35px";
}

function addFigure() {
  for (var i = 1; i < 20; i++) {
    var div = document.createElement('div');
    div.classList.add("figure");
    div.style.cssText = "background-color:green;";
    var size = i * 10;
    div.style.height = "20px"
    div.style.width = size + "px"
    document.getElementById("figures").appendChild(div);
  }
  var div = document.createElement('div');
  div.classList.add("figure");
  div.style.cssText = "background-color:brown;";
  div.style.height = "20px"
  div.style.width = "20px"
  document.getElementById("figures").appendChild(div);
}

function loopStart() {
  alert('Oh you wanted to be a rebel?');
  for (var i = 0; i < 5; i++) {
    var div = document.createElement('div');
    div.textContent = "Bad one!";
    div.setAttribute('class', 'text_normal');
    document.body.appendChild(div);
  }
}

function addElement() {
  var div = document.createElement('div');
  div.textContent = "Nice one!";
  div.setAttribute('class', 'text_normal');
  document.body.appendChild(div);
}
