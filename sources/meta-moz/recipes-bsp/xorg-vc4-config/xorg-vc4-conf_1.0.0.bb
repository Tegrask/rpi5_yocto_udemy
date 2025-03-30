SUMMARY = "Deploys x11 configuration"
LICENSE ="CLOSED"
SRC_URI = " file://99-vc4.conf "


S = "${WORKDIR}"

do_install(){
    install -d ${D}/etc/x11/xorg.conf.d
    cp -r ${S}/99-vc4.conf ${D}/etc/x11/xorg.conf.d
}

FILES:${PN}:append = " /etc/x11.conf.d/99-vc4.conf"
