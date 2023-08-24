const inputFile = document.querySelector("#picture__input");
const pictureImage = document.querySelector(".picture__image");
const pictureImageTxt = "Choose an image";
pictureImage.innerHTML = pictureImageTxt;

inputFile.addEventListener("change", function (e) {
  const inputTarget = e.target;
  const file = inputTarget.files[0];

  if (file) {
    const reader = new FileReader();

    reader.addEventListener("load", function (e) {
      const readerTarget = e.target;

	imgPreView.onload = function(imgPreViewEvent) {
		document.getElementById("preView").src = imgPreViewEvent.target.result;
		document.getElementById("preView").style.width = '450px';
		document.getElementById("preView").style.height = '450px';

	}
	
}
  