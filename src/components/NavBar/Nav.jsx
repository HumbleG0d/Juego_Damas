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
                    <li><a href="">Home</a></li>
                    <li><a href="">Playing</a></li>
                    <li><a href="">Info</a></li>
                    <li><a href="">Register</a></li>
            </ul>
        </nav>

       </header>
    
    )
}