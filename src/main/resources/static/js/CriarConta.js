const form = document.getElementById("form");
const campos = document.querySelectorAll(".required");
const spans = document.querySelectorAll(".span-required");
const emailRegex = /^([a-z0-9_\.\-])+\@(([a-z0-9\-])+\.)+([a-z0-9]{2,4})+$/;
const senhaRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z$*&@#]{5,}$/;
// const spans = document.querySelectorAll('.span-required');

// REGEX SENHA
//  (?=.*\d)              // deve conter ao menos um dígito
//  (?=.*[a-z])           // deve conter ao menos uma letra minúscula
//  (?=.*[A-Z])           // deve conter ao menos uma letra maiúscula
//  [0-9a-zA-Z$*&@#]{8,}  // deve conter ao menos 5 dos caracteres mencionados
//  $/

// Mostrar erro (borda dos inputs em cor vermelha)
function setError(index) {
  campos[index].style.border = "2px solid #e63636";
  spans[index].style.display = "block";
}

// Remover erro
function removeError(index) {
  campos[index].style.border = "2px solid #228B22";
  spans[index].style.display = "none";
}

//Validação do campo nome (caracteres)
function nomeValidate() {
  if (campos[0].value.length < 6) {
    setError(0);
  } else {
    removeError(0);
  }
}

// Validação dos campos de Email
function emailValidate() {
  if (!emailRegex.test(campos[1].value)) {
    setError(1);
  } else {
    removeError(1);
  }
}

// Comparação dos Email
function compareEmail() {
  if (campos[2].value == campos[1].value && campos[1]) {
    removeError(2);
  } else {
    setError(2);
  }
}

// Validação dos campos de Senha
function mainPasswordValidate() {
  if (!senhaRegex.test(campos[3].value)) {
    setError(3);
  } else {
    removeError(3);
    comparePassword();
  }
}

// Comparação de senhas
function comparePassword() {
  if (campos[4].value === campos[3].value && campos[3].value.length >= 5) {
    removeError(4);
  } else {
    setError(4);
  }
}
