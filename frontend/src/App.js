import "./App.css";
import LoginPage from "./components/LoginPage";
import WelcomePage from "./components/WelcomePage";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import SignUp from "./components/SignupPage";
import AddDonor from "./components/AddDonor";
import UpdateDonor from "./components/UpdateDonor";
import HomePage from "./pages/HomePage";
import MenuBar from "./components/MenuBar";
import BasicTable from "./components/BasicTable";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<WelcomePage />}></Route>
        <Route path="/Loginpage" element={<LoginPage />}></Route>
        <Route path="/SignupPage" element={<SignUp />}></Route>
        <Route path="/Homepage" element={<HomePage />}></Route>
        <Route path="/Adddonor" element={<AddDonor />}></Route>
        <Route path="/UpdateDonor/:id" element={<UpdateDonor />}></Route>
        <Route path="/MenuBar" element={<MenuBar />}></Route>
        <Route path="/BasicTable" element={<BasicTable />}></Route>
      </Routes>
    </BrowserRouter>

    // <div>
    //   <LoginPage />
    //   <WelcomePage />
    // <SignUpPage />
    // </div>
  );
}

export default App;
