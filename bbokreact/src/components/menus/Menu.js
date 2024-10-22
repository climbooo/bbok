import { useNavigate } from "react-router-dom";
import MenuCSS from "./Menu.module.css"

function Menu({ menu : {menuCode, menuImage, menuName, menuPrice}}) {

    const navigate = useNavigate();

    const onClickMenuHandler = (menuCode) => {
        navigate(`/menu/${menuCode}`, {replace: false});
    }

    return (
        <div
            className={ MenuCSS.menuDiv }
            onClick={ () => onClickMenuHandler(menuCode) }
        >
            <img src={ menuImage } alt="테스트"/>
            <h5>{ menuName }</h5>
            <h5>{ menuPrice }</h5>
        </div>
    )

}

export default Menu;