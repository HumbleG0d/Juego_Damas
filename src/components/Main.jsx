import '../styles/main.css'
import '../model/styles.css'
import Button from './Button/Button'
import Checkerboard from './ModelViewer/Checkerboard'
export default function Main() { 
    return (
        <section className='section_main'>
            <div className='div_section'>
                <div className='div_section-info'>
                    <h1>TAKE YOUR CHECKERS GAME TO THE NEXT LEVEL</h1>
                    <p>Connet with top ranked chess players from around the world and learn the secrets to becoming a checkers master.</p>
                    <Button classNameButon='section_button'>Become A Master</Button>
                </div>

                <div className='div_section-img'>
                    <div className='canvas_conteiner'>
                    <Checkerboard/>
                    </div>
                </div>
            </div>
        </section>
    )
}