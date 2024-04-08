import "../styles/board.css";
import crearTablero from "../js/matrizTablero";
import Square from "./Square/Square";

export default function Board() { 
    const tablero = crearTablero();
  return (
    <section className="tablero">
      {tablero.map((fila, indexFila) => (
        <div key={indexFila} className="casillero_filas">
          {fila.map((casilla, indexCasilla) => (
            <Square key={indexCasilla} color={(indexFila + indexCasilla) % 2 === 0 ? "#FAEDDB" : "#BB613D" } />
          ))}
        </div>
      ))}
    </section>
  );
}