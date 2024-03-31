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
                    <li className="link"><a href="">Home</a></li>
                    <li className="link"><a href="">Instructions</a></li>
                    <li className="link"><a href="">Ranking</a></li>
            </ul>
        </nav>

       </header>
    
    )
}