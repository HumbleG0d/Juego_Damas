import './App.css'
import './styles/normalize.css'
import './styles/nav.css'
import Main from './components/Main'
import Instructions from './components/Instructions'
import Ranking from './components/Ranking'
import { Routes, Route } from 'react-router-dom'
import Nav from './components/NavBar/Nav'

export default function App () {
  return (
    <>
       <Nav />
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/instructions" element={<Instructions />} />
        <Route path="/ranking" element={<Ranking />} />
      </Routes>
    </>
  )
}