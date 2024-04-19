import "../styles/board.css";
import crearTablero from "../js/matrizBoard";
import Square from "./Square/Square";
import Piece from "./Piece/Piece";
import "../styles/piece.css";
import { useState } from "react";
import validatorCol from "../play/validatorCol";
import possibleMoves from "../play/possibleMoves";

export default function Board() {
  const [tablero, setTablero] = useState(crearTablero());
  const [fichaSeleccionada, setFichaSeleccionada] = useState(null);
  const [posiblesMovimientos, setPosiblesMovimientos] = useState([]);
    console.log("Tablero: ", tablero);
  const handlePieceClick = (fila, columna) => {
      const casilla = tablero[fila][columna];
      console.log("Casilla: ", casilla);
    const movimientos = possibleMoves(casilla);
    setPosiblesMovimientos(movimientos);
    console.log("Movimientos: ", movimientos);
    setFichaSeleccionada({ fila, columna });
  };

  const handleSquareClick = (fila, columna) => {
    console.log("Cuadro: ", tablero[fila][columna]);
    console.log("Ficha: ", fichaSeleccionada);
    // Aquí puedes implementar la lógica para mover la ficha al cuadro seleccionado si es un movimiento válido
  };

  const renderizarPiezas = (indexFila, indexCasilla) => {
    if (indexFila < 3 && (indexFila + indexCasilla) % 2 === 0) {
      return (
        <Piece
          color={
            fichaSeleccionada &&
            fichaSeleccionada.fila === indexFila &&
            fichaSeleccionada.columna === indexCasilla
              ? "#6b6be2"
              : "#2c0e0d"
          }
          onClick={() => handlePieceClick(indexFila, indexCasilla)}
        />
      );
    }
    if (indexFila > 4 && (indexFila + indexCasilla) % 2 === 0) {
      return (
        <Piece
          color={
            fichaSeleccionada &&
            fichaSeleccionada.fila === indexFila &&
            fichaSeleccionada.columna === indexCasilla
              ? "#d52b2b"
              : "#dca658"
          }
          onClick={() => handlePieceClick(indexFila, indexCasilla)}
        />
      );
    }
  };

  return (
    <section className="tablero">
      {tablero.map((fila, indexFila) => (
        <div key={indexFila} className="casillero_filas">
          {fila.map((casilla, indexCasilla) => (
            <Square
              key={indexCasilla}
              className="casillero_columnas"
              color={
                (indexFila + validatorCol(casilla[1])) % 2 === 0
                  ? "#FAEDDB"
                  : "#BB613D"
              }
              oneClick={() =>
                handleSquareClick(indexFila, validatorCol(casilla[1]))
              }
            >
              {renderizarPiezas(indexFila, validatorCol(casilla[1]))}
            </Square>
          ))}
        </div>
      ))}
    </section>
  );
}
