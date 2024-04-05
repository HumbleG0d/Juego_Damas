import { Navigate } from "react-router-dom"

export default function ProtecteRoute({ children , user}) {
    if (!user) {
        return <Navigate to="/" />
    }
    return children
}