import Form from "./Form/Form";
import Campo from "./Campo/Campo";
import Button from "./Button/Button";
import '../styles/form.css'
import '../App.css'
import '../styles/form.css'

export default function FormLogin() {
    return (
        <>
          <Form>
            <div className="div_campo">
            <Campo classNameInput = "form_input" classNameLabel = "form_label-id" htmlFor="id" name="NOMBRE DE CUENTA" type="text" />  
            </div>
            <div className="div_campo">
            <Campo classNameInput="form_input" classNameLabel="form_label" htmlFor="password" name="CONTRASEÑA" type="password" />            
            </div>            
            <div className="div_campo-2">
            <Campo classNameInput="form_check" classNameLabel="form_check" htmlFor="recordar" name="Recordarme" type="checkbox" />    
            </div>
            <Button classNameButon="buttonSesion" >Iniciar sesión</Button>
            <a href="" className="form_enlace">Crear una cuenta gratuita</a>
          </Form>
        </>
    )
}