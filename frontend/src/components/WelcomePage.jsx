import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Welcome.css";

const WelcomePage = () => {
  return (
    <div className="welcome-page">
      <h1>Welcome to the Blood Bank Management System</h1>
      <p>We are here to help you manage and organize blood donations.</p>
    </div>
  );
};

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const navigate = useNavigate();

  const handleLogin = () => {
    // Perform login logic here

    // Assuming successful login, set isLoggedIn to true
    setIsLoggedIn(true);

    // Navigate to the desired route
    navigate("/Loginpage"); // Example: Navigate to the Admin page after login
  };
  return (
    <div>
      <button className="button" onClick={handleLogin}>
        Login
      </button>
      <WelcomePage />
    </div>
  );
}
export default App;
