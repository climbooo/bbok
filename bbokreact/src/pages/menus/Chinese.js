import { useDispatch, useSelector } from 'react-redux';
import Menu from '../../components/menus/Menu';
import { useEffect, useState } from 'react';
import { callMenuListAboutChineseAPI } from '../../apis/MenuAPICalls';
import MainCSS from './Menu.module.css';

function Chinese() {

    const dispatch = useDispatch();
    const chinese = useSelector(state => state.menuReducer);
    const chineseList = chinese.data;
    const pageInfo = chinese.pageInfo;
    const [currentPage, setCurrentPage] = useState(1);

    console.log('korean: ', chinese);
    console.log('koreanList: ', chineseList);

    const pageNumber = [];
    if(pageInfo) {
        for(let i = 1; i <= pageInfo.pageEnd; i++) {
            pageNumber.push(i);
        }
    }

    useEffect(
        () => {
            dispatch(callMenuListAboutChineseAPI({
                currentPage: currentPage
            }));
        }
        ,[currentPage]
    );

    return (
        <>
            <div className={ MainCSS.menuDiv }>
                {
                    Array.isArray(chineseList) && chineseList.map((chinese) => (<Menu key={ chinese.menuCode } menu={ chinese } />))
                }
            </div>
            <div style={{listStyleType: "none", display: "flex"}}>
                {Array.isArray(chineseList) &&
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
                {Array.isArray(chineseList) &&
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

export default Chinese;