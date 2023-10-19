const password = document.getElementById('password');
const icon = document.getElementById('icon-password');

function showHide (){
  if(password.type === 'password'){
    password.setAttribute('type', 'text');
    icon.classList.add('show');
  }

  else{
    password.setAttribute('type', 'password');
    icon.classList.remove('hide');
  }
}