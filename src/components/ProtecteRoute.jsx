import { Navigate } from "react-router-dom"
import { useLocation } from "react-router-dom"
export default function ProtecteRoute({ children , route}) {
    const { state } = useLocation()
    return state?.logged ? children : <Navigate to= {`/${route}`} />
}