import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Layout from './layouts/Layout';
import Main from './pages/menus/Main';
import Korean from './pages/menus/Korean';
function App() {
 
    return (
        <BrowserRouter>

            <Routes>

            <Route path="/" element={ <Layout/> }>
                <Route index element={ <Main/> }/>
                <Route path="menu/korean" element={ <Korean/> }/>
            </Route>

            </Routes>

        </BrowserRouter>
    );
}

export default App;
