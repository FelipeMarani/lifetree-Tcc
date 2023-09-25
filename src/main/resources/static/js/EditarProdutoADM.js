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
