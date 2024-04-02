import '../styles/main.css'
import Button from './Button/Button'
import Checkerboard from './ModelViewer/Checkerboard'
import { useState} from 'react'
import { Link , Outlet} from 'react-router-dom'
export default function Main() { 
    const [showLoginForm, setShowLoginForm] = useState(false)

    const [opacity, setOpacity] = useState(false)

    const handleBecomeMasterClick = () => { 
        setOpacity(true)
        setShowLoginForm(true)
    }

    if (opacity) {
        document.body.style.backgroundColor = '#404040'
        document.body.style.backdropFilter = 'blur(15px)'
    }

    return (
        <section className='section_main'>
            <div className='div_section'>
                <div className='div_section-info'>
                    <h1>TAKE YOUR CHECKERS GAME TO THE NEXT LEVEL</h1>
                    <p>Connet with top ranked chess players from around the world and learn the secrets to becoming a checkers master.</p>
                    <div className='div_button'>
                        <Link to='/login' >
                        <Button classNameButon='section_button' onClick ={handleBecomeMasterClick} >Become A Master</Button>
                    </Link>
                    </div>
                </div>

                <div className='div_section-img'>
                    <div className='canvas_conteiner'>
                    <Checkerboard/>
                    </div>
                </div>
            </div>
            {showLoginForm && <Outlet />}
        </section>
    )
}