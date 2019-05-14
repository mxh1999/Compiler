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

main_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 112
Lab_2:
          mov       r10, 0
          mov       qword [rbp-16], r10
          jmp       Lab_3
Lab_3:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-24], r10
          mov       r10, qword [rbp-24]
          xor       rax, rax
          cmp       r10, 10
          setl      al
          mov       qword [rbp-32], rax
          cmp       qword [rbp-32], 0
          jnz       Lab_4
          jmp       Lab_5
Lab_4:
          jmp       Lab_6
Lab_5:
          mov       rax, 0
          leave     
          ret       
Lab_6:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-40], r10
          mov       r10, qword [rbp-40]
          xor       rax, rax
          cmp       r10, 2
          setg      al
          mov       qword [rbp-48], rax
          mov       r10, qword [rbp-48]
          xor       r10,1
          mov       qword [rbp-56], r10
          cmp       qword [rbp-56], 0
          jnz       Lab_11
          mov       r10, qword [rbp-16]
          mov       qword [rbp-64], r10
          mov       r10, qword [rbp-64]
          xor       rax, rax
          cmp       r10, 8
          setl      al
          mov       qword [rbp-72], rax
          mov       r10, qword [rbp-72]
          mov       qword [rbp-80], r9
          jmp       Lab_10
Lab_7:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-88], r10
          mov       rdi, qword [rbp-88]
          call      toString_func
          mov       qword [rbp-96], rax
          mov       rdi, qword [rbp-96]
          call      print_func
          mov       rdi, const_1_cs
          call      print_func
          jmp       Lab_9
Lab_8:
          jmp       Lab_9
Lab_9:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-104], r10
          mov       r10, qword [rbp-104]
          add       r10, 1
          mov       qword [rbp-112], r10
          mov       r10, qword [rbp-112]
          mov       qword [rbp-16], r10
          jmp       Lab_3
Lab_10:
          cmp       qword [rbp-80], 0
          jnz       Lab_7
          jmp       Lab_8
Lab_11:
          mov       qword [rbp-80], 0
          jmp       Lab_10
          leave     
          ret       


section .data
const_1_cs:
          db        32,0     ; 
section .bss
