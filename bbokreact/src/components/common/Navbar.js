import { NavLink } from "react-router-dom";

function Navbar() {


    
    return (
        <div>
            <ul>
                <li><NavLink to="/">모든 메뉴</NavLink></li>
                <li><NavLink to="/menu/korean">한식</NavLink></li>
                <li><NavLink to="/menu/chinese">중식</NavLink></li>
                <li><NavLink to="/menu/japanese">일식</NavLink></li>
                <li><NavLink to="/menu/western">양식</NavLink></li>
                <li><NavLink to="/menu/dessert">디저트</NavLink></li>
                <li><NavLink to="/menu/beverage">음료</NavLink></li>
                <li><NavLink to="/menu/etc">기타</NavLink></li>
            </ul>
        </div>
    );
}

export default Navbar;