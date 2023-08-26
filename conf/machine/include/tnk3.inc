require conf/machine/include/k3.inc

# Common override for all TechNexion machines
MACHINEOVERRIDES =. "tn:"

# Install modules in initramfs and roofs
PACKAGE_INSTALL_append = " kernel-modules"

INITRAMFS_FSTYPES = "wic.xz"

UBOOT_SIGN_ENABLE = "0"

PREFERRED_PROVIDER_virtual/kernel:tn = "linux-tn-ti"
PREFERRED_PROVIDER_virtual/bootloader:tn = "u-boot-tn-ti"
PREFERRED_PROVIDER_u-boot:tn = "u-boot-tn-ti"

KERNEL_IMAGETYPE = "Image"
KERNEL_IMAGETYPES = "Image vmlinux.gz"
