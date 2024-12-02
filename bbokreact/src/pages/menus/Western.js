import { callMenuListAboutWesternAPI } from "../../apis/MenuAPICalls";
import Menu from "../../components/menus/Menu";
import { useEffect, useState, } from "react";
import { useSelector, useDispatch } from "react-redux";
import MainCSS from './Menu.module.css';

function Western() {

    const dispatch = useDispatch();
    const menu = useSelector(state => state.menuReducer);
    const menuList = menu.data;
    const pageInfo = menu.pageInfo;
    const [currentPage, setCurrentPage] = useState(1);

    console.log('menu: ', menu);
    console.log('menuList: ', menuList);

    const pageNumber = [];
    if(pageInfo) {
        for(let i = 1; i <= pageInfo.pageEnd; i++) {
            pageNumber.push(i);
        }
    }

    useEffect(
        () => {
            dispatch(callMenuListAboutWesternAPI({
                currentPage: currentPage
            }));
        }
        ,[currentPage]
    );

    return (
        <>
            <div className={ MainCSS.menuDiv }>
                {
                    Array.isArray(menuList) && menuList.map((menu) => (<Menu key={ menu.menuCode } menu={ menu } />))
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

export default Western;