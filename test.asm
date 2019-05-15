global main
SECTION .text

_array_size_func:
        mov     rax, [rdi]
        ret





default rel

global print_func
global println_func
global getString_func
global getInt_func
global toString_func
global _string_length_func
global _string_substring_func
global _string_parseInt_func
global _string_ord_func
global _string_add_func
global _string_less_func
global _string_lessequal_func
global _string_great_func
global _string_greaterequal_func
global _string_equal_func
global _string_notequal_func

extern strcmp
extern strcpy
extern strlen
extern __stack_chk_fail
extern __isoc99_scanf
extern malloc
extern puts
extern printf
extern _GLOBAL_OFFSET_TABLE_


SECTION .text   

print_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     rax, qword [rbp-8H]
        mov     rsi, rax
        lea     rdi, [rel L_017]
        mov     eax, 0
        call    printf
        nop
        leave
        ret


println_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     rax, qword [rbp-8H]
        mov     rdi, rax
        call    puts
        nop
        leave
        ret


getString_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     edi, 256
        call    malloc
        mov     qword [rbp-8H], rax
        mov     rax, qword [rbp-8H]
        mov     rsi, rax
        lea     rdi, [rel L_017]
        mov     eax, 0
        call    __isoc99_scanf
        mov     rax, qword [rbp-8H]
        leave
        ret


getInt_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16


        mov     rax, qword [fs:abs 28H]
        mov     qword [rbp-8H], rax
        xor     eax, eax
        lea     rax, [rbp-10H]
        mov     rsi, rax
        lea     rdi, [rel L_018]
        mov     eax, 0
        call    __isoc99_scanf
        mov     rax, qword [rbp-10H]
        mov     rdx, qword [rbp-8H]


        xor     rdx, qword [fs:abs 28H]
        jz      L_001
        call    __stack_chk_fail
L_001:  leave
        ret


toString_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 48
        mov     qword [rbp-28H], rdi
        mov     rax, qword [rbp-28H]
        mov     qword [rbp-20H], rax
        mov     qword [rbp-18H], 0
        cmp     qword [rbp-20H], 0
        jns     L_002
        add     qword [rbp-18H], 1
        neg     qword [rbp-20H]
L_002:  cmp     qword [rbp-20H], 0
        jnz     L_004
        add     qword [rbp-18H], 1
        jmp     L_004

L_003:  add     qword [rbp-18H], 1
        mov     rcx, qword [rbp-20H]
        mov     rdx, qword 6666666666666667H
        mov     rax, rcx
        imul    rdx
        sar     rdx, 2
        mov     rax, rcx
        sar     rax, 63
        sub     rdx, rax
        mov     rax, rdx
        mov     qword [rbp-20H], rax
L_004:  cmp     qword [rbp-20H], 0
        jnz     L_003
        mov     rax, qword [rbp-18H]
        add     rax, 1
        mov     rdi, rax
        call    malloc
        mov     qword [rbp-8H], rax
        mov     rdx, qword [rbp-18H]
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     byte [rax], 0
        cmp     qword [rbp-28H], 0
        jns     L_005
        mov     rax, qword [rbp-8H]
        mov     byte [rax], 45
        neg     qword [rbp-28H]
L_005:  cmp     qword [rbp-28H], 0
        jnz     L_006
        mov     rax, qword [rbp-8H]
        mov     byte [rax], 48
        mov     rax, qword [rbp-8H]
        jmp     L_011

L_006:  mov     rax, qword [rbp-18H]
        sub     rax, 1
        mov     qword [rbp-10H], rax
        jmp     L_008

L_007:  mov     rcx, qword [rbp-28H]
        mov     rdx, qword 6666666666666667H
        mov     rax, rcx
        imul    rdx
        sar     rdx, 2
        mov     rax, rcx
        sar     rax, 63
        sub     rdx, rax
        mov     rax, rdx
        shl     rax, 2
        add     rax, rdx
        add     rax, rax
        sub     rcx, rax
        mov     rdx, rcx
        mov     eax, edx
        lea     ecx, [rax+30H]
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     edx, ecx
        mov     byte [rax], dl
        mov     rcx, qword [rbp-28H]
        mov     rdx, qword 6666666666666667H
        mov     rax, rcx
        imul    rdx
        sar     rdx, 2
        mov     rax, rcx
        sar     rax, 63
        sub     rdx, rax
        mov     rax, rdx
        mov     qword [rbp-28H], rax
        cmp     qword [rbp-28H], 0
        jz      L_009
        sub     qword [rbp-10H], 1
L_008:  cmp     qword [rbp-10H], 0
        jns     L_007
        jmp     L_010

L_009:  nop
L_010:  mov     rax, qword [rbp-8H]
L_011:  leave
        ret


_string_length_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     rax, qword [rbp-8H]
        mov     rdi, rax
        call    strlen
        leave
        ret


_string_substring_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 64
        mov     qword [rbp-28H], rdi
        mov     qword [rbp-30H], rsi
        mov     qword [rbp-38H], rdx
        mov     rax, qword [rbp-38H]
        sub     rax, qword [rbp-30H]
        add     rax, 2
        mov     qword [rbp-10H], rax
        mov     rax, qword [rbp-10H]
        mov     rdi, rax
        call    malloc
        mov     qword [rbp-8H], rax
        mov     rax, qword [rbp-10H]
        lea     rdx, [rax-1H]
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     byte [rax], 0
        mov     rax, qword [rbp-30H]
        mov     qword [rbp-18H], rax
        jmp     L_013

L_012:  mov     rdx, qword [rbp-18H]
        mov     rax, qword [rbp-28H]
        lea     rcx, [rdx+rax]
        mov     rax, qword [rbp-18H]
        sub     rax, qword [rbp-30H]
        mov     rdx, rax
        mov     rax, qword [rbp-8H]
        add     rdx, rax
        movzx   eax, byte [rcx]
        mov     byte [rdx], al
        add     qword [rbp-18H], 1
L_013:  mov     rax, qword [rbp-18H]
        cmp     rax, qword [rbp-38H]
        jle     L_012
        mov     rax, qword [rbp-8H]
        leave
        ret


_string_parseInt_func:
        push    rbp
        mov     rbp, rsp
        mov     qword [rbp-18H], rdi
        mov     qword [rbp-10H], 0
        mov     rax, qword [rbp-18H]
        mov     qword [rbp-8H], rax
        jmp     L_015

L_014:  mov     rdx, qword [rbp-10H]
        mov     rax, rdx
        shl     rax, 2
        add     rax, rdx
        add     rax, rax
        mov     rdx, rax
        mov     rax, qword [rbp-8H]
        movzx   eax, byte [rax]
        movsx   rax, al
        add     rax, rdx
        sub     rax, 48
        mov     qword [rbp-10H], rax
        add     qword [rbp-8H], 1
L_015:  mov     rax, qword [rbp-8H]
        movzx   eax, byte [rax]
        cmp     al, 57
        jg      L_016
        mov     rax, qword [rbp-8H]
        movzx   eax, byte [rax]
        cmp     al, 47
        jg      L_014
L_016:  mov     rax, qword [rbp-10H]
        pop     rbp
        ret


_string_ord_func:
        push    rbp
        mov     rbp, rsp
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        movzx   eax, byte [rax]
        movsx   rax, al
        pop     rbp
        ret


_string_add_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 48
        mov     qword [rbp-28H], rdi
        mov     qword [rbp-30H], rsi
        mov     rax, qword [rbp-28H]
        mov     rdi, rax
        call    strlen
        mov     qword [rbp-18H], rax
        mov     rax, qword [rbp-30H]
        mov     rdi, rax
        call    strlen
        mov     qword [rbp-10H], rax
        mov     rdx, qword [rbp-18H]
        mov     rax, qword [rbp-10H]
        add     rax, rdx
        add     rax, 1
        mov     rdi, rax
        call    malloc
        mov     qword [rbp-8H], rax
        mov     rdx, qword [rbp-28H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcpy
        mov     rdx, qword [rbp-18H]
        mov     rax, qword [rbp-8H]
        add     rdx, rax
        mov     rax, qword [rbp-30H]
        mov     rsi, rax
        mov     rdi, rdx
        call    strcpy
        mov     rdx, qword [rbp-18H]
        mov     rax, qword [rbp-10H]
        add     rax, rdx
        mov     rdx, rax
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     byte [rax], 0
        mov     rax, qword [rbp-8H]
        leave
        ret


_string_less_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        shr     eax, 31
        leave
        ret


_string_lessequal_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        setle   al
        leave
        ret


_string_great_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        setg    al
        leave
        ret


_string_greaterequal_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        not     eax
        shr     eax, 31
        leave
        ret


_string_equal_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        sete    al
        leave
        ret


_string_notequal_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        setne   al
        leave
        ret



SECTION .data   


SECTION .bss    


SECTION .rodata 

L_017:
        db 25H, 73H, 00H

L_018:
        db 25H, 6CH, 64H, 00H


section .text
main:
          push      rbp
          mov       rbp, rsp
Lab_1:
          call      main_func
          leave     
          ret       

_vector_init_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 256
          mov       qword [rbp-24], rdi
          mov       qword [rbp-16], rsi
Lab_2:
          jmp       Lab_3
Lab_3:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-32], r10
          mov       r10, qword [rbp-32]
          xor       rax, rax
          cmp       r10, 0
          sete      al
          mov       qword [rbp-40], rax
          cmp       qword [rbp-40], 0
          jnz       Lab_4
          jmp       Lab_5
Lab_4:
          leave     
          ret       
Lab_5:
          jmp       Lab_6
Lab_6:
          mov       r10, qword [rbp-24]
          mov       qword [rbp-48], r10
          mov       r10, qword [rbp-48]
          add       r10, 0
          mov       qword [rbp-56], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-64], r10
          mov       rdi, qword [rbp-64]
          call      _array_size_func
          mov       qword [rbp-72], rax
          mov       r10, qword [rbp-72]
          imul      r10, 8
          mov       qword [rbp-80], r10
          mov       r10, qword [rbp-80]
          add       r10, 8
          mov       qword [rbp-88], r10
          mov       rdi, qword [rbp-88]
          call      malloc
          mov       qword [rbp-96], rax
          mov       r10, qword [rbp-72]
          mov       r11, qword [rbp-96]
          mov       [r11], r10
          mov       r10, qword [rbp-96]
          mov       r11, qword [rbp-56]
          mov       [r11], r10
          mov       r10, 0
          mov       qword [rbp-8], r10
          jmp       Lab_7
Lab_7:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-104], r10
          mov       rdi, qword [rbp-104]
          call      _array_size_func
          mov       qword [rbp-112], rax
          mov       r10, qword [rbp-8]
          mov       qword [rbp-120], r10
          mov       r10, qword [rbp-120]
          xor       rax, rax
          cmp       r10, qword [rbp-112]
          setl      al
          mov       qword [rbp-128], rax
          cmp       qword [rbp-128], 0
          jnz       Lab_8
          jmp       Lab_10
Lab_8:
          mov       r10, qword [rbp-24]
          mov       qword [rbp-136], r10
          mov       r10, qword [rbp-136]
          add       r10, 0
          mov       qword [rbp-144], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-152], r10
          mov       r11, qword [rbp-144]
          mov       r10, [r11]
          mov       qword [rbp-160], r10
          mov       r10, qword [rbp-152]
          imul      r10, 8
          mov       qword [rbp-168], r10
          mov       r10, qword [rbp-168]
          add       r10, 8
          mov       qword [rbp-176], r10
          mov       r10, qword [rbp-160]
          add       r10, qword [rbp-176]
          mov       qword [rbp-184], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-192], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-200], r10
          mov       r10, qword [rbp-192]
          imul      r10, 8
          mov       qword [rbp-208], r10
          mov       r10, qword [rbp-208]
          add       r10, 8
          mov       qword [rbp-216], r10
          mov       r10, qword [rbp-200]
          add       r10, qword [rbp-216]
          mov       qword [rbp-224], r10
          mov       r11, qword [rbp-224]
          mov       r10, [r11]
          mov       qword [rbp-232], r10
          mov       r10, qword [rbp-232]
          mov       r11, qword [rbp-184]
          mov       [r11], r10
          jmp       Lab_9
Lab_9:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-240], r10
          mov       r10, qword [rbp-240]
          add       r10, 1
          mov       qword [rbp-248], r10
          mov       r10, qword [rbp-248]
          mov       qword [rbp-8], r10
          jmp       Lab_7
Lab_10:
          leave     
          ret       
          leave     
          ret       

_vector_getDim_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 80
          mov       qword [rbp-8], rdi
Lab_11:
          jmp       Lab_12
Lab_12:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-16], r10
          mov       r10, qword [rbp-16]
          add       r10, 0
          mov       qword [rbp-24], r10
          mov       r11, qword [rbp-24]
          mov       r10, [r11]
          mov       qword [rbp-32], r10
          mov       r10, qword [rbp-32]
          xor       rax, rax
          cmp       r10, 0
          sete      al
          mov       qword [rbp-40], rax
          cmp       qword [rbp-40], 0
          jnz       Lab_13
          jmp       Lab_14
Lab_13:
          mov       rax, 0
          leave     
          ret       
Lab_14:
          jmp       Lab_15
Lab_15:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-48], r10
          mov       r10, qword [rbp-48]
          add       r10, 0
          mov       qword [rbp-56], r10
          mov       r11, qword [rbp-56]
          mov       r10, [r11]
          mov       qword [rbp-64], r10
          mov       rdi, qword [rbp-64]
          call      _array_size_func
          mov       qword [rbp-72], rax
          mov       rax, qword [rbp-72]
          leave     
          ret       
          leave     
          ret       

_vector_dot_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 224
          mov       qword [rbp-32], rdi
          mov       qword [rbp-24], rsi
Lab_16:
          mov       r10, 0
          mov       qword [rbp-16], r10
          mov       r10, 0
          mov       qword [rbp-8], r10
          jmp       Lab_17
Lab_17:
          mov       r10, qword [rbp-32]
          mov       qword [rbp-40], r10
          mov       rdi, qword [rbp-40]
          call      _vector_getDim_func
          mov       qword [rbp-48], rax
          mov       r10, qword [rbp-16]
          mov       qword [rbp-56], r10
          mov       r10, qword [rbp-56]
          xor       rax, rax
          cmp       r10, qword [rbp-48]
          setl      al
          mov       qword [rbp-64], rax
          cmp       qword [rbp-64], 0
          jnz       Lab_18
          jmp       Lab_19
Lab_18:
          mov       r10, qword [rbp-32]
          mov       qword [rbp-72], r10
          mov       r10, qword [rbp-72]
          add       r10, 0
          mov       qword [rbp-80], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-88], r10
          mov       r11, qword [rbp-80]
          mov       r10, [r11]
          mov       qword [rbp-96], r10
          mov       r10, qword [rbp-88]
          imul      r10, 8
          mov       qword [rbp-104], r10
          mov       r10, qword [rbp-104]
          add       r10, 8
          mov       qword [rbp-112], r10
          mov       r10, qword [rbp-96]
          add       r10, qword [rbp-112]
          mov       qword [rbp-120], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-128], r10
          mov       r10, qword [rbp-128]
          add       r10, 0
          mov       qword [rbp-136], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-144], r10
          mov       r11, qword [rbp-136]
          mov       r10, [r11]
          mov       qword [rbp-152], r10
          mov       r10, qword [rbp-144]
          imul      r10, 8
          mov       qword [rbp-160], r10
          mov       r10, qword [rbp-160]
          add       r10, 8
          mov       qword [rbp-168], r10
          mov       r10, qword [rbp-152]
          add       r10, qword [rbp-168]
          mov       qword [rbp-176], r10
          mov       r11, qword [rbp-120]
          mov       r10, [r11]
          mov       qword [rbp-184], r10
          mov       r11, qword [rbp-176]
          mov       r10, [r11]
          mov       qword [rbp-192], r10
          mov       r10, qword [rbp-184]
          imul      r10, qword [rbp-192]
          mov       qword [rbp-200], r10
          mov       r10, qword [rbp-200]
          mov       qword [rbp-8], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-208], r10
          mov       r10, qword [rbp-208]
          add       r10, 1
          mov       qword [rbp-216], r10
          mov       r10, qword [rbp-216]
          mov       qword [rbp-16], r10
          jmp       Lab_17
Lab_19:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-224], r10
          mov       rax, qword [rbp-224]
          leave     
          ret       
          leave     
          ret       

_vector_scalarInPlaceMultiply_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 272
          mov       qword [rbp-24], rdi
          mov       qword [rbp-16], rsi
Lab_20:
          jmp       Lab_21
Lab_21:
          mov       r10, qword [rbp-24]
          mov       qword [rbp-32], r10
          mov       r10, qword [rbp-32]
          add       r10, 0
          mov       qword [rbp-40], r10
          mov       r11, qword [rbp-40]
          mov       r10, [r11]
          mov       qword [rbp-48], r10
          mov       r10, qword [rbp-48]
          xor       rax, rax
          cmp       r10, 0
          sete      al
          mov       qword [rbp-56], rax
          cmp       qword [rbp-56], 0
          jnz       Lab_22
          jmp       Lab_23
Lab_22:
          mov       rax, 0
          leave     
          ret       
Lab_23:
          jmp       Lab_24
Lab_24:
          mov       r10, 0
          mov       qword [rbp-8], r10
          jmp       Lab_25
Lab_25:
          mov       r10, qword [rbp-24]
          mov       qword [rbp-64], r10
          mov       rdi, qword [rbp-64]
          call      _vector_getDim_func
          mov       qword [rbp-72], rax
          mov       r10, qword [rbp-8]
          mov       qword [rbp-80], r10
          mov       r10, qword [rbp-80]
          xor       rax, rax
          cmp       r10, qword [rbp-72]
          setl      al
          mov       qword [rbp-88], rax
          cmp       qword [rbp-88], 0
          jnz       Lab_26
          jmp       Lab_28
Lab_26:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-96], r10
          mov       rdi, qword [rbp-96]
          call      toString_func
          mov       qword [rbp-104], rax
          mov       rdi, qword [rbp-104]
          call      println_func
          mov       r11, qword [rbp-112]
          mov       r10, [r11]
          mov       qword [rbp-120], r10
          mov       r10, qword [rbp-120]
          add       r10, 0
          mov       qword [rbp-128], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-136], r10
          mov       r11, qword [rbp-128]
          mov       r10, [r11]
          mov       qword [rbp-144], r10
          mov       r10, qword [rbp-136]
          imul      r10, 8
          mov       qword [rbp-152], r10
          mov       r10, qword [rbp-152]
          add       r10, 8
          mov       qword [rbp-160], r10
          mov       r10, qword [rbp-144]
          add       r10, qword [rbp-160]
          mov       qword [rbp-168], r10
          mov       r11, qword [rbp-112]
          mov       r10, [r11]
          mov       qword [rbp-176], r10
          mov       r10, qword [rbp-176]
          add       r10, 0
          mov       qword [rbp-184], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-192], r10
          mov       r11, qword [rbp-184]
          mov       r10, [r11]
          mov       qword [rbp-200], r10
          mov       r10, qword [rbp-192]
          imul      r10, 8
          mov       qword [rbp-208], r10
          mov       r10, qword [rbp-208]
          add       r10, 8
          mov       qword [rbp-216], r10
          mov       r10, qword [rbp-200]
          add       r10, qword [rbp-216]
          mov       qword [rbp-224], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-232], r10
          mov       r11, qword [rbp-224]
          mov       r10, [r11]
          mov       qword [rbp-240], r10
          mov       r10, qword [rbp-232]
          imul      r10, qword [rbp-240]
          mov       qword [rbp-248], r10
          mov       r10, qword [rbp-248]
          mov       r11, qword [rbp-168]
          mov       [r11], r10
          jmp       Lab_27
Lab_27:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-256], r10
          mov       r10, qword [rbp-256]
          add       r10, 1
          mov       qword [rbp-264], r10
          mov       r10, qword [rbp-264]
          mov       qword [rbp-8], r10
          jmp       Lab_25
Lab_28:
          mov       r11, qword [rbp-112]
          mov       r10, [r11]
          mov       qword [rbp-272], r10
          mov       rax, qword [rbp-272]
          leave     
          ret       
          leave     
          ret       

_vector_add_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 416
          mov       qword [rbp-32], rdi
          mov       qword [rbp-24], rsi
Lab_29:
          jmp       Lab_30
Lab_30:
          mov       r10, qword [rbp-32]
          mov       qword [rbp-40], r10
          mov       rdi, qword [rbp-40]
          call      _vector_getDim_func
          mov       qword [rbp-48], rax
          mov       r10, qword [rbp-24]
          mov       qword [rbp-56], r10
          mov       rdi, qword [rbp-56]
          call      _vector_getDim_func
          mov       qword [rbp-64], rax
          mov       r10, qword [rbp-48]
          xor       rax, rax
          cmp       r10, qword [rbp-64]
          setne     al
          mov       qword [rbp-72], rax
          cmp       qword [rbp-72], 0
          jnz       Lab_35
          mov       r10, qword [rbp-32]
          mov       qword [rbp-80], r10
          mov       rdi, qword [rbp-80]
          call      _vector_getDim_func
          mov       qword [rbp-88], rax
          mov       r10, qword [rbp-88]
          xor       rax, rax
          cmp       r10, 0
          sete      al
          mov       qword [rbp-96], rax
          mov       r10, qword [rbp-96]
          mov       qword [rbp-104], r10
          jmp       Lab_34
Lab_31:
          mov       rax, 0
          leave     
          ret       
Lab_32:
          jmp       Lab_33
Lab_33:
          mov       rdi, 8
          call      malloc
          mov       qword [rbp-112], rax
          mov       r10, qword [rbp-112]
          mov       qword [rbp-16], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-120], r10
          mov       r10, qword [rbp-120]
          add       r10, 0
          mov       qword [rbp-128], r10
          mov       r10, qword [rbp-32]
          mov       qword [rbp-136], r10
          mov       rdi, qword [rbp-136]
          call      _vector_getDim_func
          mov       qword [rbp-144], rax
          mov       r10, qword [rbp-144]
          imul      r10, 8
          mov       qword [rbp-152], r10
          mov       r10, qword [rbp-152]
          add       r10, 8
          mov       qword [rbp-160], r10
          mov       rdi, qword [rbp-160]
          call      malloc
          mov       qword [rbp-168], rax
          mov       r10, qword [rbp-144]
          mov       r11, qword [rbp-168]
          mov       [r11], r10
          mov       r10, qword [rbp-168]
          mov       r11, qword [rbp-128]
          mov       [r11], r10
          mov       r10, 0
          mov       qword [rbp-8], r10
          jmp       Lab_36
Lab_34:
          cmp       qword [rbp-104], 0
          jnz       Lab_31
          jmp       Lab_32
Lab_35:
          mov       qword [rbp-104], 1
          jmp       Lab_34
Lab_36:
          mov       r10, qword [rbp-32]
          mov       qword [rbp-176], r10
          mov       rdi, qword [rbp-176]
          call      _vector_getDim_func
          mov       qword [rbp-184], rax
          mov       r10, qword [rbp-8]
          mov       qword [rbp-192], r10
          mov       r10, qword [rbp-192]
          xor       rax, rax
          cmp       r10, qword [rbp-184]
          setl      al
          mov       qword [rbp-200], rax
          cmp       qword [rbp-200], 0
          jnz       Lab_37
          jmp       Lab_39
Lab_37:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-208], r10
          mov       r10, qword [rbp-208]
          add       r10, 0
          mov       qword [rbp-216], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-224], r10
          mov       r11, qword [rbp-216]
          mov       r10, [r11]
          mov       qword [rbp-232], r10
          mov       r10, qword [rbp-224]
          imul      r10, 8
          mov       qword [rbp-240], r10
          mov       r10, qword [rbp-240]
          add       r10, 8
          mov       qword [rbp-248], r10
          mov       r10, qword [rbp-232]
          add       r10, qword [rbp-248]
          mov       qword [rbp-256], r10
          mov       r10, qword [rbp-32]
          mov       qword [rbp-264], r10
          mov       r10, qword [rbp-264]
          add       r10, 0
          mov       qword [rbp-272], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-280], r10
          mov       r11, qword [rbp-272]
          mov       r10, [r11]
          mov       qword [rbp-288], r10
          mov       r10, qword [rbp-280]
          imul      r10, 8
          mov       qword [rbp-296], r10
          mov       r10, qword [rbp-296]
          add       r10, 8
          mov       qword [rbp-304], r10
          mov       r10, qword [rbp-288]
          add       r10, qword [rbp-304]
          mov       qword [rbp-312], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-320], r10
          mov       r10, qword [rbp-320]
          add       r10, 0
          mov       qword [rbp-328], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-336], r10
          mov       r11, qword [rbp-328]
          mov       r10, [r11]
          mov       qword [rbp-344], r10
          mov       r10, qword [rbp-336]
          imul      r10, 8
          mov       qword [rbp-352], r10
          mov       r10, qword [rbp-352]
          add       r10, 8
          mov       qword [rbp-360], r10
          mov       r10, qword [rbp-344]
          add       r10, qword [rbp-360]
          mov       qword [rbp-368], r10
          mov       r11, qword [rbp-312]
          mov       r10, [r11]
          mov       qword [rbp-376], r10
          mov       r11, qword [rbp-368]
          mov       r10, [r11]
          mov       qword [rbp-384], r10
          mov       r10, qword [rbp-376]
          add       r10, qword [rbp-384]
          mov       qword [rbp-392], r10
          mov       r10, qword [rbp-392]
          mov       r11, qword [rbp-256]
          mov       [r11], r10
          jmp       Lab_38
Lab_38:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-400], r10
          mov       r10, qword [rbp-400]
          add       r10, 1
          mov       qword [rbp-408], r10
          mov       r10, qword [rbp-408]
          mov       qword [rbp-8], r10
          jmp       Lab_36
Lab_39:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-416], r10
          mov       rax, qword [rbp-416]
          leave     
          ret       
          leave     
          ret       

_vector_set_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 128
          mov       qword [rbp-24], rdi
          mov       qword [rbp-16], rsi
          mov       qword [rbp-8], rdx
Lab_40:
          jmp       Lab_41
Lab_41:
          mov       r10, qword [rbp-24]
          mov       qword [rbp-32], r10
          mov       rdi, qword [rbp-32]
          call      _vector_getDim_func
          mov       qword [rbp-40], rax
          mov       r10, qword [rbp-16]
          mov       qword [rbp-48], r10
          mov       r10, qword [rbp-40]
          xor       rax, rax
          cmp       r10, qword [rbp-48]
          setl      al
          mov       qword [rbp-56], rax
          cmp       qword [rbp-56], 0
          jnz       Lab_42
          jmp       Lab_43
Lab_42:
          mov       rax, 0
          leave     
          ret       
Lab_43:
          jmp       Lab_44
Lab_44:
          mov       r10, qword [rbp-24]
          mov       qword [rbp-64], r10
          mov       r10, qword [rbp-64]
          add       r10, 0
          mov       qword [rbp-72], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-80], r10
          mov       r11, qword [rbp-72]
          mov       r10, [r11]
          mov       qword [rbp-88], r10
          mov       r10, qword [rbp-80]
          imul      r10, 8
          mov       qword [rbp-96], r10
          mov       r10, qword [rbp-96]
          add       r10, 8
          mov       qword [rbp-104], r10
          mov       r10, qword [rbp-88]
          add       r10, qword [rbp-104]
          mov       qword [rbp-112], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-120], r10
          mov       r10, qword [rbp-120]
          mov       r11, qword [rbp-112]
          mov       [r11], r10
          mov       rax, 1
          leave     
          ret       
          leave     
          ret       

_vector_tostring_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 304
          mov       qword [rbp-24], rdi
Lab_45:
          mov       r10, const_1_cs
          mov       qword [rbp-16], r10
          jmp       Lab_46
Lab_46:
          mov       r10, qword [rbp-24]
          mov       qword [rbp-32], r10
          mov       rdi, qword [rbp-32]
          call      _vector_getDim_func
          mov       qword [rbp-40], rax
          mov       r10, qword [rbp-40]
          xor       rax, rax
          cmp       r10, 0
          setg      al
          mov       qword [rbp-48], rax
          cmp       qword [rbp-48], 0
          jnz       Lab_47
          jmp       Lab_48
Lab_47:
          mov       r10, qword [rbp-24]
          mov       qword [rbp-56], r10
          mov       r10, qword [rbp-56]
          add       r10, 0
          mov       qword [rbp-64], r10
          mov       r11, qword [rbp-64]
          mov       r10, [r11]
          mov       qword [rbp-72], r10
          mov       r10, 0
          imul      r10, 8
          mov       qword [rbp-80], r10
          mov       r10, qword [rbp-80]
          add       r10, 8
          mov       qword [rbp-88], r10
          mov       r10, qword [rbp-72]
          add       r10, qword [rbp-88]
          mov       qword [rbp-96], r10
          mov       r11, qword [rbp-96]
          mov       r10, [r11]
          mov       qword [rbp-104], r10
          mov       rdi, qword [rbp-104]
          call      toString_func
          mov       qword [rbp-112], rax
          mov       r10, qword [rbp-16]
          mov       qword [rbp-120], r10
          mov       rdi, qword [rbp-120]
          mov       rsi, qword [rbp-112]
          call      _string_add_func
          mov       qword [rbp-128], rax
          mov       r10, qword [rbp-128]
          mov       qword [rbp-16], r10
          jmp       Lab_49
Lab_48:
          jmp       Lab_49
Lab_49:
          mov       r10, 1
          mov       qword [rbp-8], r10
          jmp       Lab_50
Lab_50:
          mov       r10, qword [rbp-24]
          mov       qword [rbp-136], r10
          mov       rdi, qword [rbp-136]
          call      _vector_getDim_func
          mov       qword [rbp-144], rax
          mov       r10, qword [rbp-8]
          mov       qword [rbp-152], r10
          mov       r10, qword [rbp-152]
          xor       rax, rax
          cmp       r10, qword [rbp-144]
          setl      al
          mov       qword [rbp-160], rax
          cmp       qword [rbp-160], 0
          jnz       Lab_51
          jmp       Lab_53
Lab_51:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-168], r10
          mov       rdi, qword [rbp-168]
          mov       rsi, const_2_cs
          call      _string_add_func
          mov       qword [rbp-176], rax
          mov       r10, qword [rbp-24]
          mov       qword [rbp-184], r10
          mov       r10, qword [rbp-184]
          add       r10, 0
          mov       qword [rbp-192], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-200], r10
          mov       r11, qword [rbp-192]
          mov       r10, [r11]
          mov       qword [rbp-208], r10
          mov       r10, qword [rbp-200]
          imul      r10, 8
          mov       qword [rbp-216], r10
          mov       r10, qword [rbp-216]
          add       r10, 8
          mov       qword [rbp-224], r10
          mov       r10, qword [rbp-208]
          add       r10, qword [rbp-224]
          mov       qword [rbp-232], r10
          mov       r11, qword [rbp-232]
          mov       r10, [r11]
          mov       qword [rbp-240], r10
          mov       rdi, qword [rbp-240]
          call      toString_func
          mov       qword [rbp-248], rax
          mov       rdi, qword [rbp-176]
          mov       rsi, qword [rbp-248]
          call      _string_add_func
          mov       qword [rbp-256], rax
          mov       r10, qword [rbp-256]
          mov       qword [rbp-16], r10
          jmp       Lab_52
Lab_52:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-264], r10
          mov       r10, qword [rbp-264]
          add       r10, 1
          mov       qword [rbp-272], r10
          mov       r10, qword [rbp-272]
          mov       qword [rbp-8], r10
          jmp       Lab_50
Lab_53:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-280], r10
          mov       rdi, qword [rbp-280]
          mov       rsi, const_3_cs
          call      _string_add_func
          mov       qword [rbp-288], rax
          mov       r10, qword [rbp-288]
          mov       qword [rbp-16], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-296], r10
          mov       rax, qword [rbp-296]
          leave     
          ret       
          leave     
          ret       

_vector_copy_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 304
          mov       qword [rbp-24], rdi
          mov       qword [rbp-16], rsi
Lab_54:
          jmp       Lab_55
Lab_55:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-32], r10
          mov       r10, qword [rbp-32]
          xor       rax, rax
          cmp       r10, 0
          sete      al
          mov       qword [rbp-40], rax
          cmp       qword [rbp-40], 0
          jnz       Lab_56
          jmp       Lab_57
Lab_56:
          mov       rax, 0
          leave     
          ret       
Lab_57:
          jmp       Lab_58
Lab_58:
          jmp       Lab_59
Lab_59:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-48], r10
          mov       rdi, qword [rbp-48]
          call      _vector_getDim_func
          mov       qword [rbp-56], rax
          mov       r10, qword [rbp-56]
          xor       rax, rax
          cmp       r10, 0
          sete      al
          mov       qword [rbp-64], rax
          cmp       qword [rbp-64], 0
          jnz       Lab_60
          jmp       Lab_61
Lab_60:
          mov       r10, qword [rbp-24]
          mov       qword [rbp-72], r10
          mov       r10, qword [rbp-72]
          add       r10, 0
          mov       qword [rbp-80], r10
          mov       r10, 0
          mov       r11, qword [rbp-80]
          mov       [r11], r10
          jmp       Lab_62
Lab_61:
          mov       r10, qword [rbp-24]
          mov       qword [rbp-88], r10
          mov       r10, qword [rbp-88]
          add       r10, 0
          mov       qword [rbp-96], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-104], r10
          mov       rdi, qword [rbp-104]
          call      _vector_getDim_func
          mov       qword [rbp-112], rax
          mov       r10, qword [rbp-112]
          imul      r10, 8
          mov       qword [rbp-120], r10
          mov       r10, qword [rbp-120]
          add       r10, 8
          mov       qword [rbp-128], r10
          mov       rdi, qword [rbp-128]
          call      malloc
          mov       qword [rbp-136], rax
          mov       r10, qword [rbp-112]
          mov       r11, qword [rbp-136]
          mov       [r11], r10
          mov       r10, qword [rbp-136]
          mov       r11, qword [rbp-96]
          mov       [r11], r10
          mov       r10, 0
          mov       qword [rbp-8], r10
          jmp       Lab_63
Lab_62:
          mov       rax, 1
          leave     
          ret       
Lab_63:
          mov       r10, qword [rbp-24]
          mov       qword [rbp-144], r10
          mov       rdi, qword [rbp-144]
          call      _vector_getDim_func
          mov       qword [rbp-152], rax
          mov       r10, qword [rbp-8]
          mov       qword [rbp-160], r10
          mov       r10, qword [rbp-160]
          xor       rax, rax
          cmp       r10, qword [rbp-152]
          setl      al
          mov       qword [rbp-168], rax
          cmp       qword [rbp-168], 0
          jnz       Lab_64
          jmp       Lab_66
Lab_64:
          mov       r10, qword [rbp-24]
          mov       qword [rbp-176], r10
          mov       r10, qword [rbp-176]
          add       r10, 0
          mov       qword [rbp-184], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-192], r10
          mov       r11, qword [rbp-184]
          mov       r10, [r11]
          mov       qword [rbp-200], r10
          mov       r10, qword [rbp-192]
          imul      r10, 8
          mov       qword [rbp-208], r10
          mov       r10, qword [rbp-208]
          add       r10, 8
          mov       qword [rbp-216], r10
          mov       r10, qword [rbp-200]
          add       r10, qword [rbp-216]
          mov       qword [rbp-224], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-232], r10
          mov       r10, qword [rbp-232]
          add       r10, 0
          mov       qword [rbp-240], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-248], r10
          mov       r11, qword [rbp-240]
          mov       r10, [r11]
          mov       qword [rbp-256], r10
          mov       r10, qword [rbp-248]
          imul      r10, 8
          mov       qword [rbp-264], r10
          mov       r10, qword [rbp-264]
          add       r10, 8
          mov       qword [rbp-272], r10
          mov       r10, qword [rbp-256]
          add       r10, qword [rbp-272]
          mov       qword [rbp-280], r10
          mov       r11, qword [rbp-280]
          mov       r10, [r11]
          mov       qword [rbp-288], r10
          mov       r10, qword [rbp-288]
          mov       r11, qword [rbp-224]
          mov       [r11], r10
          jmp       Lab_65
Lab_65:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-296], r10
          mov       r10, qword [rbp-296]
          add       r10, 1
          mov       qword [rbp-304], r10
          mov       r10, qword [rbp-304]
          mov       qword [rbp-8], r10
          jmp       Lab_63
Lab_66:
          jmp       Lab_62
          leave     
          ret       

main_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 352
Lab_67:
          mov       rdi, 8
          call      malloc
          mov       qword [rbp-40], rax
          mov       r10, qword [rbp-40]
          mov       qword [rbp-32], r10
          mov       r10, 10
          imul      r10, 8
          mov       qword [rbp-48], r10
          mov       r10, qword [rbp-48]
          add       r10, 8
          mov       qword [rbp-56], r10
          mov       rdi, qword [rbp-56]
          call      malloc
          mov       qword [rbp-64], rax
          mov       r10, 10
          mov       r11, qword [rbp-64]
          mov       [r11], r10
          mov       r10, qword [rbp-64]
          mov       qword [rbp-24], r10
          mov       r10, 0
          mov       qword [rbp-16], r10
          jmp       Lab_68
Lab_68:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-72], r10
          mov       r10, qword [rbp-72]
          xor       rax, rax
          cmp       r10, 10
          setl      al
          mov       qword [rbp-80], rax
          cmp       qword [rbp-80], 0
          jnz       Lab_69
          jmp       Lab_71
Lab_69:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-88], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-96], r10
          mov       r10, qword [rbp-88]
          imul      r10, 8
          mov       qword [rbp-104], r10
          mov       r10, qword [rbp-104]
          add       r10, 8
          mov       qword [rbp-112], r10
          mov       r10, qword [rbp-96]
          add       r10, qword [rbp-112]
          mov       qword [rbp-120], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-128], r10
          mov       r10, 9
          sub       r10, qword [rbp-128]
          mov       qword [rbp-136], r10
          mov       r10, qword [rbp-136]
          mov       r11, qword [rbp-120]
          mov       [r11], r10
          jmp       Lab_70
Lab_70:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-144], r10
          mov       r10, qword [rbp-144]
          add       r10, 1
          mov       qword [rbp-152], r10
          mov       r10, qword [rbp-152]
          mov       qword [rbp-16], r10
          jmp       Lab_68
Lab_71:
          mov       r10, qword [rbp-32]
          mov       qword [rbp-160], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-168], r10
          mov       rdi, qword [rbp-160]
          mov       rsi, qword [rbp-168]
          call      _vector_init_func
          mov       rdi, const_4_cs
          call      print_func
          mov       r10, qword [rbp-32]
          mov       qword [rbp-176], r10
          mov       rdi, qword [rbp-176]
          call      _vector_tostring_func
          mov       qword [rbp-184], rax
          mov       rdi, qword [rbp-184]
          call      println_func
          mov       rdi, 8
          call      malloc
          mov       qword [rbp-192], rax
          mov       r10, qword [rbp-192]
          mov       qword [rbp-8], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-200], r10
          mov       r10, qword [rbp-32]
          mov       qword [rbp-208], r10
          mov       rdi, qword [rbp-200]
          mov       rsi, qword [rbp-208]
          call      _vector_copy_func
          mov       qword [rbp-216], rax
          jmp       Lab_72
Lab_72:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-224], r10
          mov       rdi, qword [rbp-224]
          mov       rsi, 3
          mov       rdx, 817
          call      _vector_set_func
          mov       qword [rbp-232], rax
          cmp       qword [rbp-232], 0
          jnz       Lab_73
          jmp       Lab_74
Lab_73:
          mov       rdi, const_5_cs
          call      println_func
          jmp       Lab_75
Lab_74:
          jmp       Lab_75
Lab_75:
          mov       rdi, const_6_cs
          call      print_func
          mov       r10, qword [rbp-8]
          mov       qword [rbp-240], r10
          mov       rdi, qword [rbp-240]
          call      _vector_tostring_func
          mov       qword [rbp-248], rax
          mov       rdi, qword [rbp-248]
          call      println_func
          mov       rdi, const_7_cs
          call      print_func
          mov       r10, qword [rbp-32]
          mov       qword [rbp-256], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-264], r10
          mov       rdi, qword [rbp-256]
          mov       rsi, qword [rbp-264]
          call      _vector_add_func
          mov       qword [rbp-272], rax
          mov       rdi, qword [rbp-272]
          call      _vector_tostring_func
          mov       qword [rbp-280], rax
          mov       rdi, qword [rbp-280]
          call      println_func
          mov       rdi, const_8_cs
          call      print_func
          mov       r10, qword [rbp-32]
          mov       qword [rbp-288], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-296], r10
          mov       rdi, qword [rbp-288]
          mov       rsi, qword [rbp-296]
          call      _vector_dot_func
          mov       qword [rbp-304], rax
          mov       rdi, qword [rbp-304]
          call      toString_func
          mov       qword [rbp-312], rax
          mov       rdi, qword [rbp-312]
          call      println_func
          mov       rdi, const_9_cs
          call      print_func
          mov       r10, qword [rbp-8]
          mov       qword [rbp-320], r10
          mov       r10, 1
          sal       r10, 3
          mov       qword [rbp-328], r10
          mov       rdi, qword [rbp-320]
          mov       rsi, qword [rbp-328]
          call      _vector_scalarInPlaceMultiply_func
          mov       qword [rbp-336], rax
          mov       rdi, qword [rbp-336]
          call      _vector_tostring_func
          mov       qword [rbp-344], rax
          mov       rdi, qword [rbp-344]
          call      println_func
          mov       rax, 0
          leave     
          ret       
          leave     
          ret       


section .data
const_1_cs:
          db        40,32,0     ;
const_2_cs:
          db        44,32,0     ;
const_3_cs:
          db        32,41,0     ;
const_4_cs:
          db        118,101,99,116,111,114,32,120,58,32,0     ;
const_5_cs:
          db        101,120,99,105,116,101,100,33,0     ;
const_6_cs:
          db        118,101,99,116,111,114,32,121,58,32,0     ;
const_7_cs:
          db        120,32,43,32,121,58,32,0     ;
const_8_cs:
          db        120,32,42,32,121,58,32,0     ;
const_9_cs:
          db        40,49,32,60,60,32,51,41,32,42,32,121,58,32,0     ;
section .bss
