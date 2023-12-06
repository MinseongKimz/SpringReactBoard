/*
    Header
    - 기능
      ① 전체 Layout 중 상단 차지
      ② 정보 노출
*/

import React from "react";
import Main from "./Main";
import styles from  "../../components/cssComponents/default/Header.module.css";

const Header = () => {

    return(
        <header className={styles.header}>
            <div className={styles.contents}>
                {/* Center */}
                <div className={styles.con_Center}>
                    React & SpringBoot Study 게시판
                </div>
            </div>
        </header>
    )


}

export  default  Header;