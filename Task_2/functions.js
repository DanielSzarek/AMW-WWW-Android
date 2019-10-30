var z = document.getElementById('hello');
console.log("z = ", z);
z.innerHTML = "Hello, Master!!!";

var node = document.createElement("li");
var text = document.createTextNode("Nowy");
node.appendChild(text);
document.getElementById('myList').appendChild(node);

var x1 = document.querySelector('.example');
x1.style.background = "blue";
x1.style.color = "white";
x1.onmouseover = function() {
  x1.style.backgroundColor = random_color();
  x1.style.textAlign = "center";
  x1.innerHTML = "Oppsss"
}
x1.onmouseout = function() {
  x1.style.textAlign = "left";
  x1.innerHTML = "Lorem ipsum"
}

var button_1 = document.getElementsByClassName("badge-light");
button_1[0].innerHTML = 0; // x[0] to pierwszy znaleziony element

document.getElementById("browser_info").innerHTML = navigator.appVersion;

function change_value() {
  var button = document.getElementsByClassName("badge-light");
  var value = parseInt(button[0].innerHTML, 10) + 1;
  button[0].innerHTML = value;
}

function update_progress_bar() {
  var progressBar = document.getElementById("progress_bar");
  width = 2;

  progressBar.style.width = width;

  var interval = setInterval(function() {

    width += 10;

    progressBar.style.width = ('width', width + '%');

    if (width >= 100) {
      clearInterval(interval);
    }
  }, 1000);
}

function change_background_color() {
  document.body.style.backgroundColor = random_color();
}

function random_color() {
  var letters = '0123456789ABCDEF';
  var color = '#';
  for (var i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

function new_button() {
  let button = document.createElement("button");
  button.className = "btn btn-primary";
  button.textContent = "New button!";
  button.style.margin = "3px";
  let defaultBackgroundColor = button.style.backgroundColor;
  button.onmouseover = function() {
    button.style.backgroundColor = random_color();
  }
  button.onmouseout = function() {
    button.style.backgroundColor = defaultBackgroundColor;
  }
  let section = document.getElementById("newButton");
  section.appendChild(button);
}

var marginValue = 0;

function move_element(side) {
  let move = document.getElementById("hello");

  switch (side) {
    case 'L': {
      marginValue -= 25;
      break;
    }

    case 'R': {
      marginValue += 25;
      break;
    }

    default: {}
  }

  move.style.marginLeft = (marginValue) + "px";
}

var sizeValue = 32;

function change_size(side) {
  let size_element = document.getElementById("Change_my_size");

  switch (side) {
    case 'B': {
      sizeValue += 4;
      break;
    }

    case 'S': {
      sizeValue -= 4;
      break;
    }

    default: {}
  }

  // Dodac zmianę tekstu
  size_element.style.fontSize = sizeValue + "px";
}

function alertMe() {
  alert("This is an alert!");
}

function promptMe() {
  var person = prompt("Please enter your name", "Your name");

  if (person == null || person == "") {
    txt = "User cancelled the prompt.";
  } else {
    txt = "Hello " + person + "! How are you today?";
  }
  document.getElementById("promptMsg").innerHTML = txt;
}

function confirm() {
  window.confirm("Confirm me");
}

function removeElement() {
  $(document).ready(function() {
    $("#id02").remove();
  });
}

function changeInput() {
  let input = document.getElementById('toReverse');
  let reversed = reverse(input.value);
  console.log(reversed)
  input.value = reversed;
}

function reverse(stringInput) {
  let reversed = "";
  for (let char of stringInput) {
    reversed = char + reversed;
  }
  return reversed;
}

function dontClick() {
  for (var i = 0; i < 5; i++) {
    document.body.style.backgroundColor = random_color();
    setTimeout(dontClick, 1000);
  }
}
