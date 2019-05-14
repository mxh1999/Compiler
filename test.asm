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
          sub       rsp, 96
Lab_1:
          mov       r10, 1001
          imul      r10, 8
          mov       qword [rbp-8], r10
          mov       r10, qword [rbp-8]
          add       r10, 8
          mov       qword [rbp-16], r10
          mov       rdi, qword [rbp-16]
          call      malloc
          mov       qword [rbp-24], rax
          mov       r10, 1001
          mov       r11, qword [rbp-24]
          mov       [r11], r10
          mov       r10, qword [rbp-24]
          mov       qword [@b_var], r10
          mov       r10, 170
          imul      r10, 8
          mov       qword [rbp-32], r10
          mov       r10, qword [rbp-32]
          add       r10, 8
          mov       qword [rbp-40], r10
          mov       rdi, qword [rbp-40]
          call      malloc
          mov       qword [rbp-48], rax
          mov       r10, 170
          mov       r11, qword [rbp-48]
          mov       [r11], r10
          mov       r10, qword [rbp-48]
          mov       qword [@prime_var], r10
          mov       r10, 1001
          imul      r10, 8
          mov       qword [rbp-56], r10
          mov       r10, qword [rbp-56]
          add       r10, 8
          mov       qword [rbp-64], r10
          mov       rdi, qword [rbp-64]
          call      malloc
          mov       qword [rbp-72], rax
          mov       r10, 1001
          mov       r11, qword [rbp-72]
          mov       [r11], r10
          mov       r10, qword [rbp-72]
          mov       qword [@gps_var], r10
          mov       r10, 1
          imul      r10, 8
          mov       qword [rbp-80], r10
          mov       r10, qword [rbp-80]
          add       r10, 8
          mov       qword [rbp-88], r10
          mov       rdi, qword [rbp-88]
          call      malloc
          mov       qword [rbp-96], rax
          mov       r10, 1
          mov       r11, qword [rbp-96]
          mov       [r11], r10
          mov       r10, qword [rbp-96]
          mov       qword [@tmp_var], r10
          call      main_func
          leave     
          ret       

origin_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 272
          mov       qword [rbp-8], rdi
Lab_2:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-16], r10
          mov       r10, qword [rbp-16]
          imul      r10, 8
          mov       qword [rbp-24], r10
          mov       r10, qword [rbp-24]
          add       r10, 8
          mov       qword [rbp-32], r10
          mov       rdi, qword [rbp-32]
          call      malloc
          mov       qword [rbp-40], rax
          mov       r10, qword [rbp-16]
          mov       r11, qword [rbp-40]
          mov       [r11], r10
          mov       r10, qword [rbp-40]
          mov       qword [@result_var], r10
          mov       r10, 0
          mov       qword [@i_var], r10
          jmp       Lab_3
Lab_3:
          mov       r10, qword [@i_var]
          mov       qword [rbp-48], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-56], r10
          mov       r10, qword [rbp-48]
          xor       rax, rax
          cmp       r10, qword [rbp-56]
          setl      al
          mov       qword [rbp-64], rax
          cmp       qword [rbp-64], 0
          jnz       Lab_4
          jmp       Lab_6
Lab_4:
          mov       r10, qword [@i_var]
          mov       qword [rbp-72], r10
          mov       r10, qword [@result_var]
          mov       qword [rbp-80], r10
          mov       r10, qword [rbp-72]
          imul      r10, 8
          mov       qword [rbp-88], r10
          mov       r10, qword [rbp-88]
          add       r10, 8
          mov       qword [rbp-96], r10
          mov       r10, qword [rbp-80]
          add       r10, qword [rbp-96]
          mov       qword [rbp-104], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-112], r10
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
          mov       r11, qword [rbp-104]
          mov       [r11], r10
          mov       r10, 0
          mov       qword [@j_var], r10
          jmp       Lab_7
Lab_5:
          mov       r10, qword [@i_var]
          mov       qword [rbp-144], r10
          mov       r10, qword [rbp-144]
          add       r10, 1
          mov       qword [rbp-152], r10
          mov       r10, qword [rbp-152]
          mov       qword [@i_var], r10
          jmp       Lab_3
Lab_6:
Lab_7:
          mov       r10, qword [@j_var]
          mov       qword [rbp-160], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-168], r10
          mov       r10, qword [rbp-160]
          xor       rax, rax
          cmp       r10, qword [rbp-168]
          setl      al
          mov       qword [rbp-176], rax
          cmp       qword [rbp-176], 0
          jnz       Lab_8
          jmp       Lab_10
Lab_8:
          mov       r10, qword [@i_var]
          mov       qword [rbp-184], r10
          mov       r10, qword [@result_var]
          mov       qword [rbp-192], r10
          mov       r10, qword [rbp-184]
          imul      r10, 8
          mov       qword [rbp-200], r10
          mov       r10, qword [rbp-200]
          add       r10, 8
          mov       qword [rbp-208], r10
          mov       r10, qword [rbp-192]
          add       r10, qword [rbp-208]
          mov       qword [rbp-216], r10
          mov       r10, qword [@j_var]
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
          mov       r10, 0
          mov       r11, qword [rbp-256]
          mov       [r11], r10
          jmp       Lab_9
Lab_9:
          mov       r10, qword [@j_var]
          mov       qword [rbp-264], r10
          mov       r10, qword [rbp-264]
          add       r10, 1
          mov       qword [rbp-272], r10
          mov       r10, qword [rbp-272]
          mov       qword [@j_var], r10
          jmp       Lab_7
Lab_10:
          jmp       Lab_5
          leave     
          ret       

getPrime_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 480
          mov       qword [rbp-24], rdi
Lab_11:
          mov       r10, 2
          mov       qword [rbp-16], r10
          mov       r10, 2
          mov       qword [rbp-8], r10
          jmp       Lab_12
Lab_12:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-32], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-40], r10
          mov       r10, qword [rbp-32]
          xor       rax, rax
          cmp       r10, qword [rbp-40]
          setle     al
          mov       qword [rbp-48], rax
          cmp       qword [rbp-48], 0
          jnz       Lab_13
          jmp       Lab_15
Lab_13:
          jmp       Lab_16
Lab_14:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-56], r10
          mov       r10, qword [rbp-56]
          add       r10, 1
          mov       qword [rbp-64], r10
          mov       r10, qword [rbp-64]
          mov       qword [rbp-8], r10
          jmp       Lab_12
Lab_15:
Lab_16:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-72], r10
          mov       r10, qword [@b_var]
          mov       qword [rbp-80], r10
          mov       r10, qword [rbp-72]
          imul      r10, 8
          mov       qword [rbp-88], r10
          mov       r10, qword [rbp-88]
          add       r10, 8
          mov       qword [rbp-96], r10
          mov       r10, qword [rbp-80]
          add       r10, qword [rbp-96]
          mov       qword [rbp-104], r10
          mov       r11, qword [rbp-104]
          mov       r10, [r11]
          mov       qword [rbp-112], r10
          mov       r10, qword [rbp-112]
          xor       rax, rax
          cmp       r10, 1
          sete      al
          mov       qword [rbp-120], rax
          cmp       qword [rbp-120], 0
          jnz       Lab_17
          jmp       Lab_18
Lab_17:
          mov       r10, qword [@tmp_var]
          mov       qword [rbp-128], r10
          mov       r10, 0
          imul      r10, 8
          mov       qword [rbp-136], r10
          mov       r10, qword [rbp-136]
          add       r10, 8
          mov       qword [rbp-144], r10
          mov       r10, qword [rbp-128]
          add       r10, qword [rbp-144]
          mov       qword [rbp-152], r10
          mov       r10, qword [@tmp_var]
          mov       qword [rbp-160], r10
          mov       r10, 0
          imul      r10, 8
          mov       qword [rbp-168], r10
          mov       r10, qword [rbp-168]
          add       r10, 8
          mov       qword [rbp-176], r10
          mov       r10, qword [rbp-160]
          add       r10, qword [rbp-176]
          mov       qword [rbp-184], r10
          mov       r11, qword [rbp-184]
          mov       r10, [r11]
          mov       qword [rbp-192], r10
          mov       r10, qword [rbp-192]
          add       r10, 1
          mov       qword [rbp-200], r10
          mov       r10, qword [rbp-200]
          mov       r11, qword [rbp-152]
          mov       [r11], r10
          mov       r10, qword [@tmp_var]
          mov       qword [rbp-208], r10
          mov       r10, 0
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
          mov       r10, qword [@prime_var]
          mov       qword [rbp-248], r10
          mov       r10, qword [rbp-240]
          imul      r10, 8
          mov       qword [rbp-256], r10
          mov       r10, qword [rbp-256]
          add       r10, 8
          mov       qword [rbp-264], r10
          mov       r10, qword [rbp-248]
          add       r10, qword [rbp-264]
          mov       qword [rbp-272], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-280], r10
          mov       r10, qword [rbp-280]
          mov       r11, qword [rbp-272]
          mov       [r11], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-288], r10
          mov       r10, qword [@gps_var]
          mov       qword [rbp-296], r10
          mov       r10, qword [rbp-288]
          imul      r10, 8
          mov       qword [rbp-304], r10
          mov       r10, qword [rbp-304]
          add       r10, 8
          mov       qword [rbp-312], r10
          mov       r10, qword [rbp-296]
          add       r10, qword [rbp-312]
          mov       qword [rbp-320], r10
          mov       r10, qword [@tmp_var]
          mov       qword [rbp-328], r10
          mov       r10, 0
          imul      r10, 8
          mov       qword [rbp-336], r10
          mov       r10, qword [rbp-336]
          add       r10, 8
          mov       qword [rbp-344], r10
          mov       r10, qword [rbp-328]
          add       r10, qword [rbp-344]
          mov       qword [rbp-352], r10
          mov       r11, qword [rbp-352]
          mov       r10, [r11]
          mov       qword [rbp-360], r10
          mov       r10, qword [rbp-360]
          mov       r11, qword [rbp-320]
          mov       [r11], r10
          jmp       Lab_19
Lab_18:
          jmp       Lab_19
Lab_19:
          jmp       Lab_20
Lab_20:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-368], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-376], r10
          mov       r10, qword [rbp-368]
          imul      r10, qword [rbp-376]
          mov       qword [rbp-384], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-392], r10
          mov       r10, qword [rbp-384]
          xor       rax, rax
          cmp       r10, qword [rbp-392]
          setle     al
          mov       qword [rbp-400], rax
          cmp       qword [rbp-400], 0
          jnz       Lab_21
          jmp       Lab_22
Lab_21:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-408], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-416], r10
          mov       r10, qword [rbp-408]
          imul      r10, qword [rbp-416]
          mov       qword [rbp-424], r10
          mov       r10, qword [@b_var]
          mov       qword [rbp-432], r10
          mov       r10, qword [rbp-424]
          imul      r10, 8
          mov       qword [rbp-440], r10
          mov       r10, qword [rbp-440]
          add       r10, 8
          mov       qword [rbp-448], r10
          mov       r10, qword [rbp-432]
          add       r10, qword [rbp-448]
          mov       qword [rbp-456], r10
          mov       r10, 0
          mov       r11, qword [rbp-456]
          mov       [r11], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-464], r10
          mov       r10, qword [rbp-464]
          add       r10, 1
          mov       qword [rbp-472], r10
          mov       r10, qword [rbp-472]
          mov       qword [rbp-16], r10
          jmp       Lab_20
Lab_22:
          mov       r10, 2
          mov       qword [rbp-16], r10
          jmp       Lab_14
          leave     
          ret       

getResult_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 960
          mov       qword [rbp-24], rdi
          mov       qword [rbp-16], rsi
          mov       qword [rbp-8], rdx
Lab_23:
          jmp       Lab_24
Lab_24:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-32], r10
          mov       r10, qword [@result_var]
          mov       qword [rbp-40], r10
          mov       r10, qword [rbp-32]
          imul      r10, 8
          mov       qword [rbp-48], r10
          mov       r10, qword [rbp-48]
          add       r10, 8
          mov       qword [rbp-56], r10
          mov       r10, qword [rbp-40]
          add       r10, qword [rbp-56]
          mov       qword [rbp-64], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-72], r10
          mov       r11, qword [rbp-64]
          mov       r10, [r11]
          mov       qword [rbp-80], r10
          mov       r10, qword [rbp-72]
          imul      r10, 8
          mov       qword [rbp-88], r10
          mov       r10, qword [rbp-88]
          add       r10, 8
          mov       qword [rbp-96], r10
          mov       r10, qword [rbp-80]
          add       r10, qword [rbp-96]
          mov       qword [rbp-104], r10
          mov       r10, 1
          neg       r10
          mov       qword [rbp-112], r10
          mov       r11, qword [rbp-104]
          mov       r10, [r11]
          mov       qword [rbp-120], r10
          mov       r10, qword [rbp-120]
          xor       rax, rax
          cmp       r10, qword [rbp-112]
          sete      al
          mov       qword [rbp-128], rax
          cmp       qword [rbp-128], 0
          jnz       Lab_25
          jmp       Lab_26
Lab_25:
          jmp       Lab_28
Lab_26:
          jmp       Lab_27
Lab_27:
          jmp       Lab_36
Lab_28:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-136], r10
          mov       r10, qword [@prime_var]
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
          mov       r11, qword [rbp-168]
          mov       r10, [r11]
          mov       qword [rbp-176], r10
          mov       r10, qword [rbp-176]
          imul      r10, 2
          mov       qword [rbp-184], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-192], r10
          mov       r10, qword [@prime_var]
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
          mov       r10, qword [rbp-184]
          sub       r10, qword [rbp-232]
          mov       qword [rbp-240], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-248], r10
          mov       r10, qword [rbp-240]
          xor       rax, rax
          cmp       r10, qword [rbp-248]
          setle     al
          mov       qword [rbp-256], rax
          cmp       qword [rbp-256], 0
          jnz       Lab_29
          jmp       Lab_30
Lab_29:
          jmp       Lab_32
Lab_30:
          jmp       Lab_31
Lab_31:
          jmp       Lab_27
Lab_32:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-264], r10
          mov       r10, qword [@prime_var]
          mov       qword [rbp-272], r10
          mov       r10, qword [rbp-264]
          imul      r10, 8
          mov       qword [rbp-280], r10
          mov       r10, qword [rbp-280]
          add       r10, 8
          mov       qword [rbp-288], r10
          mov       r10, qword [rbp-272]
          add       r10, qword [rbp-288]
          mov       qword [rbp-296], r10
          mov       r11, qword [rbp-296]
          mov       r10, [r11]
          mov       qword [rbp-304], r10
          mov       r10, qword [rbp-304]
          imul      r10, 2
          mov       qword [rbp-312], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-320], r10
          mov       r10, qword [@prime_var]
          mov       qword [rbp-328], r10
          mov       r10, qword [rbp-320]
          imul      r10, 8
          mov       qword [rbp-336], r10
          mov       r10, qword [rbp-336]
          add       r10, 8
          mov       qword [rbp-344], r10
          mov       r10, qword [rbp-328]
          add       r10, qword [rbp-344]
          mov       qword [rbp-352], r10
          mov       r11, qword [rbp-352]
          mov       r10, [r11]
          mov       qword [rbp-360], r10
          mov       r10, qword [rbp-312]
          sub       r10, qword [rbp-360]
          mov       qword [rbp-368], r10
          mov       r10, qword [@b_var]
          mov       qword [rbp-376], r10
          mov       r10, qword [rbp-368]
          imul      r10, 8
          mov       qword [rbp-384], r10
          mov       r10, qword [rbp-384]
          add       r10, 8
          mov       qword [rbp-392], r10
          mov       r10, qword [rbp-376]
          add       r10, qword [rbp-392]
          mov       qword [rbp-400], r10
          mov       r11, qword [rbp-400]
          mov       r10, [r11]
          mov       qword [rbp-408], r10
          mov       r10, qword [rbp-408]
          xor       rax, rax
          cmp       r10, 0
          setne     al
          mov       qword [rbp-416], rax
          cmp       qword [rbp-416], 0
          jnz       Lab_33
          jmp       Lab_34
Lab_33:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-424], r10
          mov       r10, qword [@result_var]
          mov       qword [rbp-432], r10
          mov       r10, qword [rbp-424]
          imul      r10, 8
          mov       qword [rbp-440], r10
          mov       r10, qword [rbp-440]
          add       r10, 8
          mov       qword [rbp-448], r10
          mov       r10, qword [rbp-432]
          add       r10, qword [rbp-448]
          mov       qword [rbp-456], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-464], r10
          mov       r11, qword [rbp-456]
          mov       r10, [r11]
          mov       qword [rbp-472], r10
          mov       r10, qword [rbp-464]
          imul      r10, 8
          mov       qword [rbp-480], r10
          mov       r10, qword [rbp-480]
          add       r10, 8
          mov       qword [rbp-488], r10
          mov       r10, qword [rbp-472]
          add       r10, qword [rbp-488]
          mov       qword [rbp-496], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-504], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-512], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-520], r10
          mov       r10, qword [@prime_var]
          mov       qword [rbp-528], r10
          mov       r10, qword [rbp-520]
          imul      r10, 8
          mov       qword [rbp-536], r10
          mov       r10, qword [rbp-536]
          add       r10, 8
          mov       qword [rbp-544], r10
          mov       r10, qword [rbp-528]
          add       r10, qword [rbp-544]
          mov       qword [rbp-552], r10
          mov       r11, qword [rbp-552]
          mov       r10, [r11]
          mov       qword [rbp-560], r10
          mov       r10, qword [rbp-560]
          imul      r10, 2
          mov       qword [rbp-568], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-576], r10
          mov       r10, qword [@prime_var]
          mov       qword [rbp-584], r10
          mov       r10, qword [rbp-576]
          imul      r10, 8
          mov       qword [rbp-592], r10
          mov       r10, qword [rbp-592]
          add       r10, 8
          mov       qword [rbp-600], r10
          mov       r10, qword [rbp-584]
          add       r10, qword [rbp-600]
          mov       qword [rbp-608], r10
          mov       r11, qword [rbp-608]
          mov       r10, [r11]
          mov       qword [rbp-616], r10
          mov       r10, qword [rbp-568]
          sub       r10, qword [rbp-616]
          mov       qword [rbp-624], r10
          mov       r10, qword [@gps_var]
          mov       qword [rbp-632], r10
          mov       r10, qword [rbp-624]
          imul      r10, 8
          mov       qword [rbp-640], r10
          mov       r10, qword [rbp-640]
          add       r10, 8
          mov       qword [rbp-648], r10
          mov       r10, qword [rbp-632]
          add       r10, qword [rbp-648]
          mov       qword [rbp-656], r10
          mov       r11, qword [rbp-656]
          mov       r10, [r11]
          mov       qword [rbp-664], r10
          mov       rdi, qword [rbp-504]
          mov       rsi, qword [rbp-512]
          mov       rdx, qword [rbp-664]
          call      getResult_func
          mov       qword [rbp-672], rax
          mov       r10, qword [rbp-672]
          add       r10, 1
          mov       qword [rbp-680], r10
          mov       r10, qword [rbp-680]
          mov       r11, qword [rbp-496]
          mov       [r11], r10
          jmp       Lab_35
Lab_34:
          jmp       Lab_35
Lab_35:
          jmp       Lab_31
Lab_36:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-688], r10
          mov       r10, qword [@result_var]
          mov       qword [rbp-696], r10
          mov       r10, qword [rbp-688]
          imul      r10, 8
          mov       qword [rbp-704], r10
          mov       r10, qword [rbp-704]
          add       r10, 8
          mov       qword [rbp-712], r10
          mov       r10, qword [rbp-696]
          add       r10, qword [rbp-712]
          mov       qword [rbp-720], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-728], r10
          mov       r11, qword [rbp-720]
          mov       r10, [r11]
          mov       qword [rbp-736], r10
          mov       r10, qword [rbp-728]
          imul      r10, 8
          mov       qword [rbp-744], r10
          mov       r10, qword [rbp-744]
          add       r10, 8
          mov       qword [rbp-752], r10
          mov       r10, qword [rbp-736]
          add       r10, qword [rbp-752]
          mov       qword [rbp-760], r10
          mov       r10, 1
          neg       r10
          mov       qword [rbp-768], r10
          mov       r11, qword [rbp-760]
          mov       r10, [r11]
          mov       qword [rbp-776], r10
          mov       r10, qword [rbp-776]
          xor       rax, rax
          cmp       r10, qword [rbp-768]
          sete      al
          mov       qword [rbp-784], rax
          cmp       qword [rbp-784], 0
          jnz       Lab_37
          jmp       Lab_38
Lab_37:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-792], r10
          mov       r10, qword [@result_var]
          mov       qword [rbp-800], r10
          mov       r10, qword [rbp-792]
          imul      r10, 8
          mov       qword [rbp-808], r10
          mov       r10, qword [rbp-808]
          add       r10, 8
          mov       qword [rbp-816], r10
          mov       r10, qword [rbp-800]
          add       r10, qword [rbp-816]
          mov       qword [rbp-824], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-832], r10
          mov       r11, qword [rbp-824]
          mov       r10, [r11]
          mov       qword [rbp-840], r10
          mov       r10, qword [rbp-832]
          imul      r10, 8
          mov       qword [rbp-848], r10
          mov       r10, qword [rbp-848]
          add       r10, 8
          mov       qword [rbp-856], r10
          mov       r10, qword [rbp-840]
          add       r10, qword [rbp-856]
          mov       qword [rbp-864], r10
          mov       r10, 1
          mov       r11, qword [rbp-864]
          mov       [r11], r10
          jmp       Lab_39
Lab_38:
          jmp       Lab_39
Lab_39:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-872], r10
          mov       r10, qword [@result_var]
          mov       qword [rbp-880], r10
          mov       r10, qword [rbp-872]
          imul      r10, 8
          mov       qword [rbp-888], r10
          mov       r10, qword [rbp-888]
          add       r10, 8
          mov       qword [rbp-896], r10
          mov       r10, qword [rbp-880]
          add       r10, qword [rbp-896]
          mov       qword [rbp-904], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-912], r10
          mov       r11, qword [rbp-904]
          mov       r10, [r11]
          mov       qword [rbp-920], r10
          mov       r10, qword [rbp-912]
          imul      r10, 8
          mov       qword [rbp-928], r10
          mov       r10, qword [rbp-928]
          add       r10, 8
          mov       qword [rbp-936], r10
          mov       r10, qword [rbp-920]
          add       r10, qword [rbp-936]
          mov       qword [rbp-944], r10
          mov       r11, qword [rbp-944]
          mov       r10, [r11]
          mov       qword [rbp-952], r10
          mov       rax, qword [rbp-952]
          leave     
          ret       
          leave     
          ret       

printF_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 160
          mov       qword [rbp-24], rdi
          mov       qword [rbp-16], rsi
          mov       qword [rbp-8], rdx
Lab_40:
          mov       r10, qword [rbp-24]
          mov       qword [rbp-32], r10
          mov       rdi, qword [rbp-32]
          call      toString_func
          mov       qword [rbp-40], rax
          mov       rdi, qword [rbp-40]
          call      print_func
          jmp       Lab_41
Lab_41:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-48], r10
          mov       r10, qword [rbp-48]
          xor       rax, rax
          cmp       r10, 0
          setg      al
          mov       qword [rbp-56], rax
          cmp       qword [rbp-56], 0
          jnz       Lab_42
          jmp       Lab_43
Lab_42:
          mov       rdi, const_1_cs
          call      print_func
          mov       r10, qword [rbp-16]
          mov       qword [rbp-64], r10
          mov       rdi, qword [rbp-64]
          call      toString_func
          mov       qword [rbp-72], rax
          mov       rdi, qword [rbp-72]
          call      print_func
          mov       r10, qword [rbp-16]
          mov       qword [rbp-80], r10
          mov       r10, qword [rbp-80]
          imul      r10, 2
          mov       qword [rbp-88], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-96], r10
          mov       r10, qword [rbp-88]
          sub       r10, qword [rbp-96]
          mov       qword [rbp-104], r10
          mov       r10, qword [rbp-104]
          mov       qword [rbp-16], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-112], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-120], r10
          mov       r10, qword [rbp-112]
          add       r10, qword [rbp-120]
          mov       qword [rbp-128], r10
          xor       rdx, rdx
          mov       rax, qword [rbp-128]
          mov       r10, 2
          idiv      r10
          mov       qword [rbp-136], rax
          mov       r10, qword [rbp-136]
          mov       qword [rbp-24], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-144], r10
          mov       r10, qword [rbp-144]
          sub       r10, 1
          mov       qword [rbp-152], r10
          mov       r10, qword [rbp-152]
          mov       qword [rbp-8], r10
          jmp       Lab_41
Lab_43:
          mov       rdi, const_2_cs
          call      print_func
          leave     
          ret       

main_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 1120
Lab_44:
          mov       rdi, const_3_cs
          call      println_func
          mov       rdi, 170
          call      origin_func
          mov       rdi, const_4_cs
          call      println_func
          mov       r10, 1000
          mov       qword [@N_var], r10
          call      getInt_func
          mov       qword [rbp-8], rax
          mov       r10, qword [rbp-8]
          mov       qword [@M_var], r10
          mov       r10, 0
          mov       qword [@primeCount_var], r10
          mov       r10, 0
          mov       qword [@resultCount_var], r10
          mov       r10, qword [@tmp_var]
          mov       qword [rbp-16], r10
          mov       r10, 0
          imul      r10, 8
          mov       qword [rbp-24], r10
          mov       r10, qword [rbp-24]
          add       r10, 8
          mov       qword [rbp-32], r10
          mov       r10, qword [rbp-16]
          add       r10, qword [rbp-32]
          mov       qword [rbp-40], r10
          mov       r10, 0
          mov       r11, qword [rbp-40]
          mov       [r11], r10
          mov       r10, 0
          mov       qword [@i_var], r10
          jmp       Lab_45
Lab_45:
          mov       r10, qword [@N_var]
          mov       qword [rbp-48], r10
          mov       r10, qword [rbp-48]
          add       r10, 1
          mov       qword [rbp-56], r10
          mov       r10, qword [@i_var]
          mov       qword [rbp-64], r10
          mov       r10, qword [rbp-64]
          xor       rax, rax
          cmp       r10, qword [rbp-56]
          setl      al
          mov       qword [rbp-72], rax
          cmp       qword [rbp-72], 0
          jnz       Lab_46
          jmp       Lab_48
Lab_46:
          mov       r10, qword [@i_var]
          mov       qword [rbp-80], r10
          mov       r10, qword [@b_var]
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
          mov       r10, 1
          mov       r11, qword [rbp-112]
          mov       [r11], r10
          mov       r10, qword [@i_var]
          mov       qword [rbp-120], r10
          mov       r10, qword [@gps_var]
          mov       qword [rbp-128], r10
          mov       r10, qword [rbp-120]
          imul      r10, 8
          mov       qword [rbp-136], r10
          mov       r10, qword [rbp-136]
          add       r10, 8
          mov       qword [rbp-144], r10
          mov       r10, qword [rbp-128]
          add       r10, qword [rbp-144]
          mov       qword [rbp-152], r10
          mov       r10, 0
          mov       r11, qword [rbp-152]
          mov       [r11], r10
          jmp       Lab_47
Lab_47:
          mov       r10, qword [@i_var]
          mov       qword [rbp-160], r10
          mov       r10, qword [rbp-160]
          add       r10, 1
          mov       qword [rbp-168], r10
          mov       r10, qword [rbp-168]
          mov       qword [@i_var], r10
          jmp       Lab_45
Lab_48:
          mov       r10, 0
          mov       qword [@i_var], r10
          jmp       Lab_49
Lab_49:
          mov       r10, qword [@M_var]
          mov       qword [rbp-176], r10
          mov       r10, qword [rbp-176]
          add       r10, 1
          mov       qword [rbp-184], r10
          mov       r10, qword [@i_var]
          mov       qword [rbp-192], r10
          mov       r10, qword [rbp-192]
          xor       rax, rax
          cmp       r10, qword [rbp-184]
          setl      al
          mov       qword [rbp-200], rax
          cmp       qword [rbp-200], 0
          jnz       Lab_50
          jmp       Lab_52
Lab_50:
          mov       r10, qword [@i_var]
          mov       qword [rbp-208], r10
          mov       r10, qword [@prime_var]
          mov       qword [rbp-216], r10
          mov       r10, qword [rbp-208]
          imul      r10, 8
          mov       qword [rbp-224], r10
          mov       r10, qword [rbp-224]
          add       r10, 8
          mov       qword [rbp-232], r10
          mov       r10, qword [rbp-216]
          add       r10, qword [rbp-232]
          mov       qword [rbp-240], r10
          mov       r10, 0
          mov       r11, qword [rbp-240]
          mov       [r11], r10
          jmp       Lab_51
Lab_51:
          mov       r10, qword [@i_var]
          mov       qword [rbp-248], r10
          mov       r10, qword [rbp-248]
          add       r10, 1
          mov       qword [rbp-256], r10
          mov       r10, qword [rbp-256]
          mov       qword [@i_var], r10
          jmp       Lab_49
Lab_52:
          mov       r10, 0
          mov       qword [@i_var], r10
          jmp       Lab_53
Lab_53:
          mov       r10, qword [@i_var]
          mov       qword [rbp-264], r10
          mov       r10, qword [@M_var]
          mov       qword [rbp-272], r10
          mov       r10, qword [rbp-264]
          xor       rax, rax
          cmp       r10, qword [rbp-272]
          setle     al
          mov       qword [rbp-280], rax
          cmp       qword [rbp-280], 0
          jnz       Lab_54
          jmp       Lab_56
Lab_54:
          mov       r10, 0
          mov       qword [@j_var], r10
          jmp       Lab_57
Lab_55:
          mov       r10, qword [@i_var]
          mov       qword [rbp-288], r10
          mov       r10, qword [rbp-288]
          add       r10, 1
          mov       qword [rbp-296], r10
          mov       r10, qword [rbp-296]
          mov       qword [@i_var], r10
          jmp       Lab_53
Lab_56:
          mov       rdi, const_5_cs
          call      println_func
          mov       r10, qword [@N_var]
          mov       qword [rbp-304], r10
          mov       rdi, qword [rbp-304]
          call      getPrime_func
          mov       qword [rbp-312], rax
          mov       rdi, const_6_cs
          call      println_func
          mov       r10, qword [@tmp_var]
          mov       qword [rbp-320], r10
          mov       r10, 0
          imul      r10, 8
          mov       qword [rbp-328], r10
          mov       r10, qword [rbp-328]
          add       r10, 8
          mov       qword [rbp-336], r10
          mov       r10, qword [rbp-320]
          add       r10, qword [rbp-336]
          mov       qword [rbp-344], r10
          mov       r11, qword [rbp-344]
          mov       r10, [r11]
          mov       qword [rbp-352], r10
          mov       r10, qword [rbp-352]
          mov       qword [@primeCount_var], r10
          mov       r10, 1
          mov       qword [@i_var], r10
          jmp       Lab_61
Lab_57:
          mov       r10, qword [@j_var]
          mov       qword [rbp-360], r10
          mov       r10, qword [@M_var]
          mov       qword [rbp-368], r10
          mov       r10, qword [rbp-360]
          xor       rax, rax
          cmp       r10, qword [rbp-368]
          setle     al
          mov       qword [rbp-376], rax
          cmp       qword [rbp-376], 0
          jnz       Lab_58
          jmp       Lab_60
Lab_58:
          mov       r10, qword [@i_var]
          mov       qword [rbp-384], r10
          mov       r10, qword [@result_var]
          mov       qword [rbp-392], r10
          mov       r10, qword [rbp-384]
          imul      r10, 8
          mov       qword [rbp-400], r10
          mov       r10, qword [rbp-400]
          add       r10, 8
          mov       qword [rbp-408], r10
          mov       r10, qword [rbp-392]
          add       r10, qword [rbp-408]
          mov       qword [rbp-416], r10
          mov       r10, qword [@j_var]
          mov       qword [rbp-424], r10
          mov       r11, qword [rbp-416]
          mov       r10, [r11]
          mov       qword [rbp-432], r10
          mov       r10, qword [rbp-424]
          imul      r10, 8
          mov       qword [rbp-440], r10
          mov       r10, qword [rbp-440]
          add       r10, 8
          mov       qword [rbp-448], r10
          mov       r10, qword [rbp-432]
          add       r10, qword [rbp-448]
          mov       qword [rbp-456], r10
          mov       r10, 1
          neg       r10
          mov       qword [rbp-464], r10
          mov       r10, qword [rbp-464]
          mov       r11, qword [rbp-456]
          mov       [r11], r10
          jmp       Lab_59
Lab_59:
          mov       r10, qword [@j_var]
          mov       qword [rbp-472], r10
          mov       r10, qword [rbp-472]
          add       r10, 1
          mov       qword [rbp-480], r10
          mov       r10, qword [rbp-480]
          mov       qword [@j_var], r10
          jmp       Lab_57
Lab_60:
          jmp       Lab_55
Lab_61:
          mov       r10, qword [@i_var]
          mov       qword [rbp-488], r10
          mov       r10, qword [@primeCount_var]
          mov       qword [rbp-496], r10
          mov       r10, qword [rbp-488]
          xor       rax, rax
          cmp       r10, qword [rbp-496]
          setl      al
          mov       qword [rbp-504], rax
          cmp       qword [rbp-504], 0
          jnz       Lab_62
          jmp       Lab_64
Lab_62:
          mov       r10, qword [@i_var]
          mov       qword [rbp-512], r10
          mov       r10, qword [rbp-512]
          add       r10, 1
          mov       qword [rbp-520], r10
          mov       r10, qword [rbp-520]
          mov       qword [@j_var], r10
          jmp       Lab_65
Lab_63:
          mov       r10, qword [@i_var]
          mov       qword [rbp-528], r10
          mov       r10, qword [rbp-528]
          add       r10, 1
          mov       qword [rbp-536], r10
          mov       r10, qword [rbp-536]
          mov       qword [@i_var], r10
          jmp       Lab_61
Lab_64:
          mov       rdi, const_7_cs
          call      print_func
          mov       r10, qword [@resultCount_var]
          mov       qword [rbp-544], r10
          mov       rdi, qword [rbp-544]
          call      toString_func
          mov       qword [rbp-552], rax
          mov       rdi, qword [rbp-552]
          call      println_func
          mov       rax, 0
          leave     
          ret       
Lab_65:
          mov       r10, qword [@j_var]
          mov       qword [rbp-560], r10
          mov       r10, qword [@primeCount_var]
          mov       qword [rbp-568], r10
          mov       r10, qword [rbp-560]
          xor       rax, rax
          cmp       r10, qword [rbp-568]
          setle     al
          mov       qword [rbp-576], rax
          cmp       qword [rbp-576], 0
          jnz       Lab_66
          jmp       Lab_68
Lab_66:
          jmp       Lab_69
Lab_67:
          mov       r10, qword [@j_var]
          mov       qword [rbp-584], r10
          mov       r10, qword [rbp-584]
          add       r10, 1
          mov       qword [rbp-592], r10
          mov       r10, qword [rbp-592]
          mov       qword [@j_var], r10
          jmp       Lab_65
Lab_68:
          jmp       Lab_63
Lab_69:
          mov       r10, qword [@i_var]
          mov       qword [rbp-600], r10
          mov       r10, qword [@result_var]
          mov       qword [rbp-608], r10
          mov       r10, qword [rbp-600]
          imul      r10, 8
          mov       qword [rbp-616], r10
          mov       r10, qword [rbp-616]
          add       r10, 8
          mov       qword [rbp-624], r10
          mov       r10, qword [rbp-608]
          add       r10, qword [rbp-624]
          mov       qword [rbp-632], r10
          mov       r10, qword [@j_var]
          mov       qword [rbp-640], r10
          mov       r11, qword [rbp-632]
          mov       r10, [r11]
          mov       qword [rbp-648], r10
          mov       r10, qword [rbp-640]
          imul      r10, 8
          mov       qword [rbp-656], r10
          mov       r10, qword [rbp-656]
          add       r10, 8
          mov       qword [rbp-664], r10
          mov       r10, qword [rbp-648]
          add       r10, qword [rbp-664]
          mov       qword [rbp-672], r10
          mov       r10, 1
          neg       r10
          mov       qword [rbp-680], r10
          mov       r11, qword [rbp-672]
          mov       r10, [r11]
          mov       qword [rbp-688], r10
          mov       r10, qword [rbp-688]
          xor       rax, rax
          cmp       r10, qword [rbp-680]
          sete      al
          mov       qword [rbp-696], rax
          cmp       qword [rbp-696], 0
          jnz       Lab_70
          jmp       Lab_71
Lab_70:
          mov       r10, qword [@i_var]
          mov       qword [rbp-704], r10
          mov       r10, qword [@result_var]
          mov       qword [rbp-712], r10
          mov       r10, qword [rbp-704]
          imul      r10, 8
          mov       qword [rbp-720], r10
          mov       r10, qword [rbp-720]
          add       r10, 8
          mov       qword [rbp-728], r10
          mov       r10, qword [rbp-712]
          add       r10, qword [rbp-728]
          mov       qword [rbp-736], r10
          mov       r10, qword [@j_var]
          mov       qword [rbp-744], r10
          mov       r11, qword [rbp-736]
          mov       r10, [r11]
          mov       qword [rbp-752], r10
          mov       r10, qword [rbp-744]
          imul      r10, 8
          mov       qword [rbp-760], r10
          mov       r10, qword [rbp-760]
          add       r10, 8
          mov       qword [rbp-768], r10
          mov       r10, qword [rbp-752]
          add       r10, qword [rbp-768]
          mov       qword [rbp-776], r10
          mov       r10, qword [@N_var]
          mov       qword [rbp-784], r10
          mov       r10, qword [@i_var]
          mov       qword [rbp-792], r10
          mov       r10, qword [@j_var]
          mov       qword [rbp-800], r10
          mov       rdi, qword [rbp-784]
          mov       rsi, qword [rbp-792]
          mov       rdx, qword [rbp-800]
          call      getResult_func
          mov       qword [rbp-808], rax
          mov       r10, qword [rbp-808]
          mov       r11, qword [rbp-776]
          mov       [r11], r10
          jmp       Lab_73
Lab_71:
          jmp       Lab_72
Lab_72:
          jmp       Lab_67
Lab_73:
          mov       r10, qword [@i_var]
          mov       qword [rbp-816], r10
          mov       r10, qword [@result_var]
          mov       qword [rbp-824], r10
          mov       r10, qword [rbp-816]
          imul      r10, 8
          mov       qword [rbp-832], r10
          mov       r10, qword [rbp-832]
          add       r10, 8
          mov       qword [rbp-840], r10
          mov       r10, qword [rbp-824]
          add       r10, qword [rbp-840]
          mov       qword [rbp-848], r10
          mov       r10, qword [@j_var]
          mov       qword [rbp-856], r10
          mov       r11, qword [rbp-848]
          mov       r10, [r11]
          mov       qword [rbp-864], r10
          mov       r10, qword [rbp-856]
          imul      r10, 8
          mov       qword [rbp-872], r10
          mov       r10, qword [rbp-872]
          add       r10, 8
          mov       qword [rbp-880], r10
          mov       r10, qword [rbp-864]
          add       r10, qword [rbp-880]
          mov       qword [rbp-888], r10
          mov       r11, qword [rbp-888]
          mov       r10, [r11]
          mov       qword [rbp-896], r10
          mov       r10, qword [rbp-896]
          xor       rax, rax
          cmp       r10, 1
          setg      al
          mov       qword [rbp-904], rax
          cmp       qword [rbp-904], 0
          jnz       Lab_74
          jmp       Lab_75
Lab_74:
          mov       r10, qword [@i_var]
          mov       qword [rbp-912], r10
          mov       r10, qword [@prime_var]
          mov       qword [rbp-920], r10
          mov       r10, qword [rbp-912]
          imul      r10, 8
          mov       qword [rbp-928], r10
          mov       r10, qword [rbp-928]
          add       r10, 8
          mov       qword [rbp-936], r10
          mov       r10, qword [rbp-920]
          add       r10, qword [rbp-936]
          mov       qword [rbp-944], r10
          mov       r11, qword [rbp-944]
          mov       r10, [r11]
          mov       qword [rbp-952], r10
          mov       r10, qword [@j_var]
          mov       qword [rbp-960], r10
          mov       r10, qword [@prime_var]
          mov       qword [rbp-968], r10
          mov       r10, qword [rbp-960]
          imul      r10, 8
          mov       qword [rbp-976], r10
          mov       r10, qword [rbp-976]
          add       r10, 8
          mov       qword [rbp-984], r10
          mov       r10, qword [rbp-968]
          add       r10, qword [rbp-984]
          mov       qword [rbp-992], r10
          mov       r11, qword [rbp-992]
          mov       r10, [r11]
          mov       qword [rbp-1000], r10
          mov       r10, qword [@i_var]
          mov       qword [rbp-1008], r10
          mov       r10, qword [@result_var]
          mov       qword [rbp-1016], r10
          mov       r10, qword [rbp-1008]
          imul      r10, 8
          mov       qword [rbp-1024], r10
          mov       r10, qword [rbp-1024]
          add       r10, 8
          mov       qword [rbp-1032], r10
          mov       r10, qword [rbp-1016]
          add       r10, qword [rbp-1032]
          mov       qword [rbp-1040], r10
          mov       r10, qword [@j_var]
          mov       qword [rbp-1048], r10
          mov       r11, qword [rbp-1040]
          mov       r10, [r11]
          mov       qword [rbp-1056], r10
          mov       r10, qword [rbp-1048]
          imul      r10, 8
          mov       qword [rbp-1064], r10
          mov       r10, qword [rbp-1064]
          add       r10, 8
          mov       qword [rbp-1072], r10
          mov       r10, qword [rbp-1056]
          add       r10, qword [rbp-1072]
          mov       qword [rbp-1080], r10
          mov       r11, qword [rbp-1080]
          mov       r10, [r11]
          mov       qword [rbp-1088], r10
          mov       rdi, qword [rbp-952]
          mov       rsi, qword [rbp-1000]
          mov       rdx, qword [rbp-1088]
          call      printF_func
          mov       qword [rbp-1096], rax
          mov       r10, qword [@resultCount_var]
          mov       qword [rbp-1104], r10
          mov       r10, qword [rbp-1104]
          add       r10, 1
          mov       qword [rbp-1112], r10
          mov       r10, qword [rbp-1112]
          mov       qword [@resultCount_var], r10
          jmp       Lab_76
Lab_75:
          jmp       Lab_76
Lab_76:
          jmp       Lab_72
          leave     
          ret       


section .data
const_1_cs:
          db        32,0     ; 
const_2_cs:
          db        10,0     ;\n
const_3_cs:
          db        45,49,0     ;-1
const_4_cs:
          db        111,107,48,0     ;ok0
const_5_cs:
          db        111,107,49,0     ;ok1
const_6_cs:
          db        111,107,50,0     ;ok2
const_7_cs:
          db        84,111,116,97,108,58,32,0     ;Total: 
section .bss
@N_var:
          resb      8
@M_var:
          resb      8
@i_var:
          resb      8
@j_var:
          resb      8
@primeCount_var:
          resb      8
@resultCount_var:
          resb      8
@b_var:
          resb      8
@prime_var:
          resb      8
@gps_var:
          resb      8
@tmp_var:
          resb      8
@result_var:
          resb      8
