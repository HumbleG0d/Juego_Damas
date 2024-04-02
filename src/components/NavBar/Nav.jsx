import { Link } from "react-router-dom"
export default function Nav() { 
    return (
        <header className="header">
            <div className="div_header">
                <a href="">
                    <img src="/src/assets/logo/logo.png" alt="" className="img"/>
                </a>
            </div>
            <nav className="navbar">
            <ul className="links">
                    <li className="link"><Link to="/">Home</Link></li>
                    <li className="link"><Link to="/instructions">Instructions</Link></li>
                    <li className="link"><Link to="/ranking">Ranking</Link></li>
            </ul>
        </nav>

       </header>
    
    )
}