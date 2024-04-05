import Form from "./Form/Form"
import Campo from "./Campo/Campo"
import Button from "./Button/Button"
import "../styles/normalize.css"
import "../styles/form.css"
import { useForm } from "react-hook-form"
import { AiFillCloseCircle } from "react-icons/ai";
import { Link , Outlet , useNavigate } from "react-router-dom"

export default function FormRegister () {
  const { register, handleSubmit, formState: { errors } } = useForm()

  const navigate = useNavigate();

  const onSubmit = handleSubmit((data) => {
    console.log(data)
    navigate('/play')
  })

  return (
    <>
    <div className="div_form form-container">
      <Link to="/">
        <AiFillCloseCircle className="close" />
       
        </Link>
        <p className="title">Register</p>
        
      <Form onSubmit={onSubmit} className="form">
        <div className="input-group">
          <Campo
            classNameLabel="form_label"
            classNameInput="form_input"
            htmlFor="username"
            name="Username"
              type="text"
              register={register}
            />
            {errors.username && <span className="form_error">{errors.username.message}</span>}

        </div>
        <div className="input-group">
          <Campo
            classNameLabel="form_label"
            classNameInput="form_input"
            htmlFor="password"
            name="Password"
              type="password"
              register={register}
            />
            {errors.password && <span className="form_error">{errors.password.message}</span>}
          </div>
          
          <div className="input-group">
          <Campo
            classNameLabel="form_label"
            classNameInput="form_input"
            htmlFor="password1"
            name="Confirm Password"
              type="password"
              register={register}
            />
            {errors.password && <span className="form_error">{errors.password.message}</span>}
          </div>
          <div className="input-group">
                <Campo classNameInput="form_input" classNameLabel="form_label-id" htmlFor="correo" name="Email" type="email" register={register} />
                {errors.correo && <span className="form_error">{errors.correo.message}</span>}
            </div>
        <Button classNameButon="register">Register</Button>
      </Form>
    </div>
    <Outlet/>
    </>
  )
}
