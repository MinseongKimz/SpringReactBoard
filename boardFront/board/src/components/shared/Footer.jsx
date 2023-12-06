/*
    Footer
    - 기능
      ① 전체 Layout 중 하단 차지
      ② 정보 노출
*/

import React from "react";
import styles from "../../components/cssComponents/default/Footer.module.css"


const Footer = () => {

    return(
        <footer className={styles.footer}>
            <div className={styles.contents}>
                <div className={styles.inner}>
                    <div>© Copyright 2023 JSW</div>
                    <div>Terms and Conditions</div>
                    <div>Privacy Policy</div>
                </div>
            </div>
        </footer>
    )


}

export  default  Footer;