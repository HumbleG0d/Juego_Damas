import "../styles/board.css";
import crearTablero from "../js/matrizBoard";
import Square from "./Square/Square";
import Piece from "./Piece/Piece";
import '../styles/piece.css';
export default function Board() {

    const renderizarPiezas = (indexFila , indexCasilla) => {
        if(indexFila < 3 && (indexFila + indexCasilla) % 2 == 0){
            return <Piece color="#2c0e0d"/>
        }
        if(indexFila > 4 && (indexFila + indexCasilla) % 2 !== 0){
            return <Piece color="#dca658"/>
        }
    }

  const tablero = crearTablero();
  return (
    <section className="tablero">
    {tablero.map((fila, indexFila) => (
        <div key={indexFila} className="casillero_filas">
            {fila.map(
                (casilla, indexCasilla) => (
                    <Square key={indexCasilla} className="casillero_columnas"
                    color={(indexFila + indexCasilla) % 2 === 0 ? "#FAEDDB" : "#BB613D"}
                    >
                        {renderizarPiezas(indexFila, indexCasilla)}
                    </Square>
                )
            )}
        </div>
    ))}
    </section>
  );
}
