/* --------------------------- NO TOCAR DESDE ACÁ --------------------------- */
let datosPersona = {
  nombre: "",
  edad: 0,
  ciudad: "",
  interesPorJs: "",
};

const listado = [{
    imgUrl: "https://huguidugui.files.wordpress.com/2015/03/html1.png",
    lenguajes: "HTML y CSS",
    bimestre: "1er bimestre",
  },
  {
    imgUrl: "https://upload.wikimedia.org/wikipedia/commons/d/d4/Javascript-shield.svg",
    lenguajes: "Javascript",
    bimestre: "2do bimestre",
  },
  {
    imgUrl: "https://ensocore.com/media/61/reactjs-logo-sticker%20%281%29.jpg",
    lenguajes: "React JS",
    bimestre: "3er bimestre",
  },
];

const profileBtn = document.querySelector("#completar-perfil");
const materiasBtn = document.querySelector("#obtener-materias");
const cambiarTema = document.querySelector('#cambiar-tema');

profileBtn.addEventListener("click", renderizarDatosUsuario);
materiasBtn.addEventListener("click", recorrerListadoYRenderizarTarjetas);
cambiarTema.addEventListener("click", alternarColorTema);
/* --------------------------- NO TOCAR HASTA ACÁ --------------------------- */

/* --------------- PUNTO 1: --------------- */
function obtenerDatosDelUsuario() {
  obtenerNombre();
  obtenerEdad();
  obtenerCiudad();
  datosPersona.interesPorJs = confirm("¿Te interesa Javascript?:");
};

function obtenerEdad() {
  const year = new Date().getFullYear();
  let nacimiento = prompt("Ingresa el año de tu nacimiento:");
  while (!/^[0-9]+$/.test(nacimiento) | nacimiento < 1900 | nacimiento > year) {
    alert("No ingresaste un año válido");
    nacimiento = prompt("Ingresa el año de tu nacimiento ");
  };
  datosPersona.edad = year - nacimiento;
};

function obtenerNombre() {
  let nombre =  prompt("Ingresa tu Nombre:");
  while (/^[0-9]+$/.test(nombre) | nombre == "") {
    alert("No ingresaste un nombre válido");
    nombre = prompt("Ingresa tu nombre ");
  };
  datosPersona.nombre = nombre;
};

function obtenerCiudad() {
  let ciudad =  prompt("Ingresa tu Ciudad de Residencia:");
  while (/^[0-9]+$/.test(ciudad) | ciudad == "") {
    alert("No ingresaste una Ciudad valida");
    ciudad = prompt("Ingresa tu Ciudad de Residencia: ");
  };
  datosPersona.ciudad = ciudad;
};

/* --------------- PUNTO 2: --------------- */
function renderizarDatosUsuario() {
  obtenerDatosDelUsuario();
  document.querySelector("#nombre").innerText = datosPersona.nombre;
  document.querySelector("#edad").innerText = datosPersona.edad;
  document.querySelector("#ciudad").innerText = datosPersona.ciudad;
  leInteresaJS();
  document.querySelector("#javascript").innerText = datosPersona.interesPorJs;
};  

function leInteresaJS() {
  if(datosPersona.interesPorJs){
    datosPersona.interesPorJs = "Si";
  } else{
    datosPersona.interesPorJs = "No";
  };
};

/* ------------------ PUNTO 3: ------------------ */
var seHizoClick = false;  
function recorrerListadoYRenderizarTarjetas() {
  const contenedorCartas = document.querySelector("#fila");
  if(!seHizoClick){
    listado.forEach((lis) => {
    const cardClases = `
    <div class="caja" >
        <img src=${lis.imgUrl} alt="logo de ${lis.lenguajes}"/>
        <p class="lenguajes">
          Lenguajes: ${lis.lenguajes}
        </p>
        <p class"bimestre">
          Bimestre: ${lis.bimestre}
        </p>
    </div>`;
    contenedorCartas.innerHTML += cardClases;
    });
  };
seHizoClick = true;
};

/* --------------------- PUNTO 4: --------------------- */
function alternarColorTema() {
  const boton = document.querySelector('#sitio');
  boton.classList.toggle('dark');
};

/* --------------------- PUNTO 5: --------------------- */
const parrafoOculto = document.querySelector(".oculto");
window.addEventListener("keypress", (e) => {
  if (e.key == "f") {
    parrafoOculto.classList.remove("oculto");
  };
});