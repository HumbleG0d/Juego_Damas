import './App.css'
import './styles/normalize.css'
import './styles/nav.css'
import Main from './components/Main'
import Instructions from './components/Instructions'
import Ranking from './components/Ranking'
import { Routes, Route} from 'react-router-dom'
import Nav from './components/NavBar/Nav'
import FormLogin from './components/FormLogin'
import Play from './components/Play'
import ProtecteRoute from './components/ProtecteRoute'
import FormRegister from './components/FormRegister'
export default function App() {
  
  return (
    <>
      <Nav />
        <Routes>
        <Route path="/" element={<Main />}>
          <Route path="login" element={<FormLogin />}/>
          <Route path="register" element={<FormRegister />} />
        </Route>
        <Route path="/instructions" element={<Instructions />} />
        <Route path="/ranking" element={<Ranking />} />
        <Route path="/play" element={<ProtecteRoute user={null}>
          <Play /> /**Cambiar el null por los datos traidos del back */
        </ProtecteRoute>} />
      </Routes>
    </>
  )
}