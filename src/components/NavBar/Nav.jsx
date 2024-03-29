//import { HiMiniBars4 } from "react-icons/hi2";
//import { navigationItems } from './navigationItems'
//import { useState } from 'react'
export default function Nav() { 
  //  const [openMenu, setOpenMenu] = useState(false)
    
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

{/*<div className='navbar_menu-container'>
                <HiMiniBars4 className='navbar_menu' onClick={() => setOpenMenu(!openMenu)} />
            </div> */}
                

        </nav>

       </header>
    
    )
}