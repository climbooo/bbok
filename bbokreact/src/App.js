import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Layout from './layouts/Layout';
import Main from './pages/menus/Main';
import Korean from './pages/menus/Korean';
import Chinese from './pages/menus/Chinese';
import Beverage from './pages/menus/Beverage';
import Japanese from './pages/menus/Japanese';
import Western from './pages/menus/Western';
import Dessert from './pages/menus/Dessert';
import Etc from './pages/menus/Etc';
function App() {
 
    return (
        <BrowserRouter>

            <Routes>

            <Route path="/" element={ <Layout/> }>
                <Route index element={ <Main/> }/>
                <Route path="menu/korean" element={ <Korean/> }/>
                <Route path="menu/chinese" element={ <Chinese/> }/>
                <Route path="menu/japanese" element={ <Japanese/> }/>
                <Route path="menu/western" element={ <Western/> }/>
                <Route path="menu/dessert" element={ <Dessert/> }/>
                <Route path="menu/beverage" element={ <Beverage/> }/>
                <Route path="menu/etc" element={ <Etc/> }/>
            </Route>

            </Routes>

        </BrowserRouter>
    );
}

export default App;
