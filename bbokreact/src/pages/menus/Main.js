import { useNavigate } from "react-router-dom";
import MainCSS from "./Menu.module.css";
import Menu from "../../components/menus/Menu";
import { useDispatch, useSelector } from "react-redux";

import {
    callMenuListAPI
} from "../../apis/MenuAPICalls";
import { useEffect, useState } from "react";

function Main() {

    const navigate = useNavigate();
    const dispatch = useDispatch();
    const menus = useSelector(state => state.menuReducer);
    const menuList = menus.data;
    const pageInfo = menus.pageInfo;

    console.log('menus: ', menus);
    console.log('menuList: ', menuList);

    const [currentPage, setCurrentPage] = useState(1);

    const pageNumber = [];
    if(pageInfo) {
        for(let i = 1; i <= pageInfo.pageEnd; i++) {
            pageNumber.push(i);
        }
    }

    useEffect(
        () => {
            dispatch(callMenuListAPI({
                currentPage: currentPage
            }));
        }
        ,[currentPage]
    )

    return (
        <>
            <div className={MainCSS.menuDiv}>
            {
                Array.isArray(menuList) && menuList.map((menu) => (<Menu key={menu.menuCode} menu={menu}/>))
            }
            </div>
            <div style={{listStyleType: "none", display: "flex"}}>
                {Array.isArray(menuList) &&
                <button
                    onClick={() => setCurrentPage(currentPage - 1)}
                    disabled={currentPage === 1}
                    className={MainCSS.pagingBtn}
                >
                    &lt;
                </button>
                }
                {pageNumber.map((num) => (
                <li key={num} onClick={() => setCurrentPage(num)}>
                    <button
                        style={currentPage === num ? {backgroundColor : 'orange'} : null}
                        className={MainCSS.pagingBtn}
                    >
                        {num}
                    </button>
                </li>
                ))}
                {Array.isArray(menuList) &&
                <button
                    onClick={() => setCurrentPage(currentPage + 1)}
                    disabled={currentPage === pageInfo.pageEnd || pageInfo.total == 0}
                    className={MainCSS.pagingBtn}
                >
                    &gt;
                </button>
                }
            </div>
        </>
    );
}

export default Main;