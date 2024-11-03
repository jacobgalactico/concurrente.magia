// Colores cíclicos para los hechizos
const hechizoColores = ["#33FF57", "#FFD700", "#FF5733", "#33B5FF", "#FF33FF"]; // Verde, amarillo, naranja, azul, morado

// Definición de los hechizos con colores asignados cíclicamente
const hechizos1 = [
    { nombre: "Expelliarmus", tipo: "Defensivo", nivel: 2, desbloqueado: true, color: hechizoColores[0 % hechizoColores.length] },
    { nombre: "Expecto Patronum", tipo: "Defensivo", nivel: 5, desbloqueado: true, color: hechizoColores[1 % hechizoColores.length] },
    { nombre: "Sectumsempra", tipo: "Ofensivo", nivel: 6, desbloqueado: false, victoriasNecesarias: 1, color: hechizoColores[2 % hechizoColores.length] },
    { nombre: "Crucio", tipo: "Ofensivo", nivel: 8, desbloqueado: false, victoriasNecesarias: 2, color: hechizoColores[3 % hechizoColores.length] },
    { nombre: "Avada Kedavra", tipo: "Ofensivo", nivel: 10, desbloqueado: false, victoriasNecesarias: 3, color: hechizoColores[4 % hechizoColores.length] }
];

const hechizos2 = JSON.parse(JSON.stringify(hechizos1)); // Clona los hechizos para el segundo jugador

let vida1 = 100, vida2 = 100;
let victorias1 = 0, victorias2 = 0;
let pocimas1 = 3, pocimas2 = 3;
let turnoJugador = 1;

function mostrarRayo(color) {
    const rayo = document.getElementById("rayo");
    rayo.style.background = `linear-gradient(to bottom, rgba(255, 255, 255, 0), ${color}, rgba(255, 255, 255, 0))`;
    rayo.style.opacity = "1";
    rayo.style.animation = "none";
    setTimeout(() => {
        rayo.style.animation = ""; // Reinicia la animación
    }, 10);
}

function agitarMago(jugador) {
    const mago = jugador === 1 ? document.getElementById("mago-rojo") : document.getElementById("mago-azul");
    mago.classList.add("agitado");
    setTimeout(() => {
        mago.classList.remove("agitado");
    }, 200);
}

function usarHechizo(jugador, hechizo, index) {
    if (turnoJugador !== jugador) {
        alert("No es tu turno");
        return;
    }
    if (!hechizo.desbloqueado) {
        alert("Este hechizo está bloqueado");
        return;
    }

    mostrarRayo(hechizo.color); // Pasamos el color del hechizo al rayo
    agitarMago(jugador === 1 ? 2 : 1); // Agitar el mago que recibe el daño

    const daño = hechizo.nivel * 5;
    if (jugador === 1) vida2 -= daño;
    else vida1 -= daño;

    actualizarBarraDeVida(1);
    actualizarBarraDeVida(2);

    turnoJugador = jugador === 1 ? 2 : 1;

    if (vida1 <= 0 || vida2 <= 0) {
        if (vida1 <= 0) {
            victorias2++;
            pocimas2++;
            desbloquearHechizos(2); // Desbloquear hechizos para el jugador 2
        }
        if (vida2 <= 0) {
            victorias1++;
            pocimas1++;
            desbloquearHechizos(1); // Desbloquear hechizos para el jugador 1
        }

        alert(`Jugador ${jugador} ha ganado!`);
        vida1 = 100;
        vida2 = 100;

        actualizarVictorias();
        actualizarPocimas();
        actualizarBarraDeVida(1);
        cargarHechizos(); // Recargar la lista de hechizos para actualizar el estado de bloqueo
    }
}

function desbloquearHechizos(jugador) {
    const hechizos = jugador === 1 ? hechizos1 : hechizos2;
    const victorias = jugador === 1 ? victorias1 : victorias2;

    hechizos.forEach(hechizo => {
        if (!hechizo.desbloqueado && victorias >= hechizo.victoriasNecesarias) {
            hechizo.desbloqueado = true;
        }
    });
}

function actualizarBarraDeVida(jugador) {
    const barra = document.getElementById("vida-barra" + jugador);
    const vidaRestante = document.getElementById("vida-restante" + jugador);
    const vida = jugador === 1 ? vida1 : vida2;
    barra.style.width = vida + "%";
    vidaRestante.textContent = "Vida: " + vida;
}

function cargarHechizos() {
    const lista1 = document.getElementById("hechizos-lista1");
    const lista2 = document.getElementById("hechizos-lista2");
    lista1.innerHTML = '';
    lista2.innerHTML = '';

    hechizos1.forEach((hechizo, index) => {
        const item = document.createElement("li");
        item.textContent = `${hechizo.nombre} - Tipo: ${hechizo.tipo} - Nivel: ${hechizo.nivel}`;
        if (!hechizo.desbloqueado) item.classList.add("bloqueado");
        item.onclick = () => usarHechizo(1, hechizo, index);
        lista1.appendChild(item);
    });

    hechizos2.forEach((hechizo, index) => {
        const item = document.createElement("li");
        item.textContent = `${hechizo.nombre} - Tipo: ${hechizo.tipo} - Nivel: ${hechizo.nivel}`;
        if (!hechizo.desbloqueado) item.classList.add("bloqueado");
        item.onclick = () => usarHechizo(2, hechizo, index);
        lista2.appendChild(item);
    });
}

function actualizarVictorias() {
    document.getElementById("victorias-jugador1").textContent = `Victorias: ${victorias1}`;
    document.getElementById("victorias-jugador2").textContent = `Victorias: ${victorias2}`;
}

function actualizarPocimas() {
    document.getElementById("pocimas-jugador1").textContent = `Pócimas restantes: ${pocimas1}`;
    document.getElementById("pocimas-jugador2").textContent = `Pócimas restantes: ${pocimas2}`;
    document.getElementById("boton-pocion1").disabled = pocimas1 === 0;
    document.getElementById("boton-pocion2").disabled = pocimas2 === 0;
}

cargarHechizos();
actualizarBarraDeVida(1);
actualizarVictorias();
actualizarPocimas();
