const API_PELICULAS = "http://localhost:8081/api";
const API_RENTAS = "http://localhost:8082/api";

function cargarPeliculas() {
    fetch(`${API_PELICULAS}/peliculas`)
        .then(res => res.json())
        .then(data => {
            const lista = document.getElementById("lista");
            lista.innerHTML = "";
            data.forEach(p => {
                const li = document.createElement("li");
                li.textContent = p;
                lista.appendChild(li);
            });
        });
}

function rentar() {
    const nombre = document.getElementById("peli").value;

    fetch(`${API_RENTAS}/rentar`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ nombre })
    })
    .then(res => res.text())
    .then(alert);
}

// PWA
if ("serviceWorker" in navigator) {
    navigator.serviceWorker.register("service-worker.js");
}