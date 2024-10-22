import { useDispatch, useSelector } from 'react-redux';
import Menu from '../../components/menus/Menu';
import { useEffect, useState } from 'react';
import { callMenuListAboutKoreanAPI } from '../../apis/MenuAPICalls';
import MainCSS from './Menu.module.css';

function Korean() {

    const dispatch = useDispatch();
    const korean = useSelector(state => state.menuReducer);
    const koreanList = korean.data;
    const pageInfo = korean.pageInfo;
    const [currentPage, setCurrentPage] = useState(1);

    console.log('korean: ', korean);
    console.log('koreanList: ', koreanList);

    const pageNumber = [];
    if(pageInfo) {
        for(let i = 1; i <= pageInfo.pageEnd; i++) {
            pageNumber.push(i);
        }
    }

    useEffect(
        () => {
            dispatch(callMenuListAboutKoreanAPI({
            }));
        }
        ,[]
    );

    return (
        <>
            <div className={ MainCSS.menuDiv }>
                {
                    koreanList.length > 0 && koreanList.map((korean) => (<Menu key={ korean.menuCode } menu={ korean } />))
                }
            </div>
            <div style={{listStyleType: "none", display: "flex"}}>
                {Array.isArray(koreanList) &&
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
                {Array.isArray(koreanList) &&
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

export default Korean;