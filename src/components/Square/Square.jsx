export default function Square({color , children}) {
  return (
    <article
      className="casillero_columnas"
      style={{ backgroundColor: color }}
    >
      {children}
    </article>
  );
}
