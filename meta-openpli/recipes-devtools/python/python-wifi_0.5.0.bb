SUMMARY = "Provides access to Linux Wireless Extensions"
HOMEPAGE = "http://pythonwifi.wikispot.org/"
SECTION = "devel/python"
LICENSE = "LGPLv2+"
LICENSE_${PN}-examples = "GPLv2+"
LIC_FILES_CHKSUM = "file://README;beginline=56;endline=57;md5=31ebd3ff22b6f3c0160a143e0c4a98a3 \
                    file://examples/iwconfig.py;beginline=1;endline=20;md5=60fd41501905b3e20e9065995edfc0cf \
                    file://pythonwifi/iwlibs.py;beginline=1;endline=22;md5=679475d61cc083a24158bb8b473f0c6f"
RDEPENDS_${PN} = "python-ctypes python-datetime"
PR = "r1"

SRC_URI = "http://download.berlios.de/pythonwifi/${P}.tar.bz2"
SRC_URI[md5sum] = "c8d84360d896fd0df70a5fc598e79f69"
SRC_URI[sha256sum] = "2733b9beb6a5e5c13e9685b60df9cb93e4d87901366c0cac3b36536a875bcb97"

inherit setuptools

do_install_append() {
        install -d ${D}${docdir}/${PN}
        mv ${D}${datadir}/README ${D}${docdir}/${PN}
        mv ${D}${datadir}/INSTALL ${D}${docdir}/${PN}
        mv ${D}${datadir}/docs/* ${D}${docdir}/${PN}
        rmdir ${D}${datadir}/docs
        install -d ${D}${sbindir}
        mv ${D}${datadir}/examples/* ${D}${sbindir}
        rmdir ${D}${datadir}/examples
}

PACKAGES =+ "${PN}-examples"

FILES_${PN}-examples = "${sbindir}"
