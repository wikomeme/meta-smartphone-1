require recipes-kernel/linux/linux.inc

SECTION = "kernel"

# Mark archs/machines that this kernel supports
COMPATIBLE_MACHINE = "hammerhead"

DESCRIPTION = "Linux kernel for the LG Hammerhead (Nexus 5) device based on the offical \
source from Google/LG"

SRC_URI = " \
  git://github.com/Halium/android_kernel_lge_hammerhead.git;branch=halium-5.1 \
  file://overlayfs.v13-3.4-rc7.patch \
  file://0001-Add-pid-and-mount-namespaces.patch \
"
S = "${WORKDIR}/git"

CMDLINE = "${ANDROID_BOOTIMG_CMDLINE}"

do_configure_prepend() {
    cp -v -f ${S}/arch/arm/configs/cyanogenmod_hammerhead_defconfig ${WORKDIR}/defconfig
    echo "CONFIG_SQUASHFS=y" >> ${WORKDIR}/defconfig
    echo "CONFIG_VETH=y" >> ${WORKDIR}/defconfig
    echo "CONFIG_MISC_FILESYSTEMS=y" >> ${WORKDIR}/defconfig
    echo "CONFIG_SQUASHFS=y" >> ${WORKDIR}/defconfig
    echo "CONFIG_SQUASHFS_FILE_CACHE=y" >> ${WORKDIR}/defconfig
    echo "CONFIG_SQUASHFS_DECOMP_SINGLE=y" >> ${WORKDIR}/defconfig
    echo "CONFIG_SQUASHFS_ZLIB=y" >> ${WORKDIR}/defconfig
    echo "CONFIG_SQUASHFS_XZ=y" >> ${WORKDIR}/defconfig
    echo "CONFIG_SQUASHFS_FRAGMENT_CACHE_SIZE=3" >> ${WORKDIR}/defconfig
}

SRCREV = "5b2e4b8d36260feea46f4ae3b955ba997a26b5fb"

KV = "3.4.0"
PV = "${KV}+gitr${SRCPV}"
# for bumping PR bump MACHINE_KERNEL_PR in the machine config
inherit machine_kernel_pr
