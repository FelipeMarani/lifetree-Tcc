const inputFile = document.querySelector("#picture__input");
const pictureImage = document.querySelector(".picture__image");
const pictureImageTxt = "Escolha uma imagem para o seu produto";

/* Pré Visualização da Imagem Escolhida */
function preViewImg() {
  var imgPreView = new FileReader();
  imgPreView.readAsDataURL(document.getElementById("uploadImage").files[0]);

  imgPreView.onload = function (imgPreViewEvent) {
    document.getElementById("preView").src = imgPreViewEvent.target.result;
    document.getElementById("preView").style.width = "450px";
    document.getElementById("preView").style.height = "450px";
  };
}
const inputText = document.getElementById("txtTextArea");

function adjustHeight() {
  inputText.style.height = "auto";
  inputText.style.height = inputText.scrollHeight + "px";
}

inputText.addEventListener("input", adjustHeight);

adjustHeight();
var names = document.getElementById("Names");
input.addEventListener("input", function () {
  const valor = names.value;
  const letrasRestantes = 35 - valor.length;
});
