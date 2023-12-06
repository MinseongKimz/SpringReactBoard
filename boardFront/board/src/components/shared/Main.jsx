/*
    Main
    - 기능
      ① 전체 Layout 중 중앙 차지
      ② 정보 노출
*/

import React from "react";
import {Routes, Route} from "react-router-dom";

import BoardList from "../../components/default/BoardList";
import BoardSave from "../../components/default/BoardSave";
import BoardDetail from "../../components/default/BoardDetail";


import styles from "../../components/cssComponents/default/Main.module.css";
const Main = () => {

    return(
        <main className={styles.main}>
            <div>
                <Routes>
                    <Route path="/" element={<BoardList />}></Route>
                    <Route path="/default/BoardList" element={<BoardList />}></Route>

                    <Route path="/default/BoardSave" element={<BoardSave />}></Route>
                    <Route path="/default/BoardDetail" element={<BoardDetail />}></Route>

                </Routes>
            </div>
        </main>
    )
}

export  default  Main;