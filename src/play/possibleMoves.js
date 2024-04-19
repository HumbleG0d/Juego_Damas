import crearTablero from "../js/matrizBoard";
import validatorCol from "./validatorCol";
export default function possibleMoves(casilla) {
  const tablero = crearTablero();
  const fila = casilla[0] - 1;
  const columna = validatorCol(casilla[1]);

  console.log("Fila: ", fila);
  console.log("Columna: ", columna);

  if (fila <= 2 && tablero[fila][columna] !== null) {
    return [tablero[fila + 1][columna - 1], tablero[fila + 1][columna + 1]];
  } else {
    return [tablero[fila - 1][columna - 1], tablero[fila - 1][columna + 1]];
  }
}
