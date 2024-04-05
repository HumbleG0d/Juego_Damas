import { Link, useLocation } from "react-router-dom";
export default function Nav() {
  const { state } = useLocation();
  return (
    <header className="header">
      <div className="div_header">
        <Link to="/">
          <img src="/src/assets/logo/logo.png" alt="" className="img" />
        </Link>
      </div>

      {state?.logged ? (
        <div className="navbar_perfil">
          <img src="" alt="" />
          <label className="perfil">{state?.username}</label>
          <select name="options perfil" id="">
            <option value="nameperfil">View Profile</option>
            <option value="salir">Sign Off </option>
          </select>
        </div>
      ) : (
        <nav className="navbar">
          <ul className="links">
            <li className="link">
              <Link to="/">Home</Link>
            </li>
            <li className="link">
              <Link to="/instructions">Instructions</Link>
            </li>
            <li className="link">
              <Link to="/ranking">Ranking</Link>
            </li>
          </ul>
        </nav>
      )}
    </header>
  );
}
