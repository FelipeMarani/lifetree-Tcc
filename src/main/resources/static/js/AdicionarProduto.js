const inputFile = document.querySelector("#picture__input");
const pictureImage = document.querySelector(".picture__image");
const pictureImageTxt = "Escolha uma imagem para o seu produto";

/* Pré Visualização da Imagem Escolhida */
function preViewImg() {
	var imgPreView = new FileReader();
	imgPreView.readAsDataURL(document.getElementById("uploadImage").files[0]);

	imgPreView.onload = function(imgPreViewEvent) {
		document.getElementById("preView").src = imgPreViewEvent.target.result;
		document.getElementById("preView").style.width = '450px';
		document.getElementById("preView").style.height = '450px';

	}
	
}
  
function autoResize()
{
	objTextArea = document.getElementById('txtTextArea');
	while (objTextArea.scrollHeight > objTextArea.offsetHeight)
	{
		objTextArea.rows += 1;
	}
}

//const inputText = document.getElementById("input-text");
// Função para ajustar a altura do textarea conforme o conteúdo
//function adjustHeight() {
  //  inputText.style.height = "auto"; // Redefine a altura para calcular o tamanho real
  //  inputText.style.height = inputText.scrollHeight + "px"; // Define a altura com base no conteúdo
//}

// Adicione um ouvinte de evento de digitação para o textarea
//inputText.addEventListener("input", adjustHeight);

// Chame a função inicialmente para definir a altura correta
//adjustHeight();